package com.guoguo.javaAudition.job;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.*;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-06-26 17:06
 */
@Service
public class TimeCallbackServiceImpl implements TimeCallbackService{

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeCallbackServiceImpl.class);

    private final ExecutorService unboundExecutor =
            new ThreadPoolExecutor(0 , Integer.MAX_VALUE ,
                    60L , TimeUnit.SECONDS,
                    new SynchronousQueue<>(),
                    new ThreadFactoryBuilder()
                        .setNameFormat("TimeCallbackService-%d")
                        .build());

    private final DelayQueue<DelayedCallbackWrapper> queue = new DelayQueue<>();

    private volatile boolean running = true;

    @PostConstruct
    public void init(){
        unboundExecutor.execute(()->{
            try {
                mainLoop();
            }catch (Exception e){
                LOGGER.error("主循环线程退出!");
            }
        });
    }

    private void mainLoop() {
        while (running){
            try {
                final DelayedCallbackWrapper wrapper = queue.take();
                unboundExecutor.execute(wrapper);
            }catch (Exception e){
                LOGGER.error("ignore timer call back Exception" , e);
            }
        }

    }


    @PreDestroy
    public void stop(){
        running = false;
        try {
            queue.add(new DelayedCallbackWrapper(()->{} , 1 , TimeUnit.MILLISECONDS));
        }finally {
            unboundExecutor.shutdown();
        }

    }



    @Override
    public void runAfter(Runnable r, long timeout, TimeUnit tm, boolean override) {

        UniqueDelayedCallbackWrapper wrapper = new UniqueDelayedCallbackWrapper(r, timeout, tm);
        synchronized (queue){
            if (override){
                queue.remove(wrapper);
            }
            queue.add(wrapper);
        }


    }


    private static class UniqueDelayedCallbackWrapper extends DelayedCallbackWrapper{
        UniqueDelayedCallbackWrapper(Runnable r, long timeout, TimeUnit unit) {
            super(r , timeout , unit);
        }

        @Override
        public int hashCode(){
            final int prime = 31;
            int result = 1;
            result = prime + result + ((r == null)? 0 : r.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object object){
            if (this == object){return true;}
            if (object == null){return  false;}
            if (getClass() != object.getClass()){return false;}
            UniqueDelayedCallbackWrapper other = (UniqueDelayedCallbackWrapper) object;
            if (r == null){
                if (other.r != null){return false;}
            }else if (!r.equals(other.r)){return false;}
            return true;
        }
    }

    private static class DelayedCallbackWrapper implements Delayed , Runnable {

        protected static final Logger LOGGER = LoggerFactory.getLogger(DelayedCallbackWrapper.class);
        protected final  Runnable r;
        final long expiredTime;

        DelayedCallbackWrapper(Runnable r, long timeout , TimeUnit unit){
            this.r = r;
            this.expiredTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(timeout , unit);
        }


        @Override
        public void run() {
            try {
                r.run();
            }catch (Exception e){
                LOGGER.error("DelayedCallbackWrapper定时调用指定的回调出错",e);
            }
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(expiredTime - System.nanoTime() , TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            DelayedCallbackWrapper that = (DelayedCallbackWrapper) o;
            return Long.compare(expiredTime , that.expiredTime);
        }
    }
}