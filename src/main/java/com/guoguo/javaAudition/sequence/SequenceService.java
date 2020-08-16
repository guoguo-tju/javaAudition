package com.guoguo.javaAudition.sequence;

import com.google.common.collect.Sets;
import com.guoguo.javaAudition.common.Log;
import com.guoguo.javaAudition.common.ParamUtils;
import com.guoguo.javaAudition.example.TransactionTemplateService;
import com.guoguo.javaAudition.job.TimeCallbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 描述:
 *
 *  sequence表设计:
 *
 *      id 主键
 *      gmt_create
 *      gmt_modified
 *      sequence_name 序号表类型
 *      sequence_desc 序号表用途
 *      sequence_valule  序号值
 *
 *      uk_sequence_name
 *
 *
 * @author guozh
 * @create 2020-08-16 16:14
 */

@Service
public class SequenceService implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(SequenceService.class);

    private final Map<Sequence , SequenceCache> cache = new HashMap<>();

    @Autowired
    private TransactionTemplateService transactionTemplateService;

    @Autowired
    private TimeCallbackService timeCallbackService;


    @Override
    public void afterPropertiesSet() throws Exception {
        Set<String> nameSet = Sets.newHashSet();
        for (Sequence sequence : Sequence.values()) {
            cache.put(sequence , new SequenceCache(sequence));
            nameSet.add(sequence.getName().toLowerCase());
        }
    }



    public long getVaule(Sequence sequence){
        return cache.get(sequence).get();
    }


    private class SequenceCache {

        private Sequence sequence;
        private SequenceLoader sequenceLoader;
        private AtomicLong maxValue = new AtomicLong(Long.MIN_VALUE);
        private AtomicLong currVaule = new AtomicLong(0);

        SequenceCache(Sequence sequence){
            this.sequence = sequence;
            this.sequenceLoader = new SequenceLoader(sequence);
        }


        long get(){
            long max = maxValue.get();
            long current = currVaule.incrementAndGet();
            while(current > max){
                synchronized (sequence){
                    max = maxValue.get();
                    current = currVaule.incrementAndGet();
                    // 双重检查
                    if(current > max){
                        // 新线程中执行数据库更新 , 保证其事务隔离性及可见性
                        SeqResult seqResult = timeCallbackService.wait(sequenceLoader , null , 5 , TimeUnit.SECONDS);
                        ParamUtils.assertNotNull(seqResult , "载入{}序号出错" , sequence);

                        currVaule.set(seqResult.min);
                        current = currVaule.incrementAndGet();

                        max = seqResult.max;
                        maxValue.set(max);
                    }else{
                        Log.info(LOGGER , "并发更新序号: {} > {}" , current , max);
                    }
                }


            }
            return  current;
        }

    }

    private class SequenceLoader implements Callable<SeqResult> {

        private Sequence sequence;

        SequenceLoader(Sequence sequence){
            this.sequence = sequence;
        }

        @Override
        public SeqResult call() throws Exception {
            return transactionTemplateService.tx(()->{
                String name = this.sequence.getName();

                // select sequence_value from common_sequence where sequence_name = #{name} for update nowait
//              Long min = sequenceMapper.getSequence();
                Long min = 0L;

                long max = min + sequence.getStep();

                // update common_sequence set gmt_modified = CURRENT_TIMESTAMP , sequence_value = #{newValue} where sequence_name = #{name} and sequence_value = #{oldVaule}
//                int ret = sequenceMapper.update(name , min , max);
                int ret = 1;
                ParamUtils.assertTrue(ret == 1 , "{}序号生成异常,由{}更新到{}失败,返回:{}" , name , min , max , ret);
                return new SeqResult(min , max);
            });
        }
    }



    private class SeqResult {
        private long min , max;

        SeqResult(long min , long max){
            this.min = min;
            this.max = max;
        }
    }
}