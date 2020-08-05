package com.guoguo.javaAudition.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.guoguo.javaAudition.common.Log;
import com.guoguo.javaAudition.common.Operator;
import com.guoguo.javaAudition.job.TimeCallbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 *  Guave Cache
 *      介绍: https://juejin.im/post/6844903748393926664
 *      多级缓存: https://juejin.im/post/6844903747160637447
 *
 * Optional<T>
 *     介绍: https://juejin.im/post/6844903945714794503
 *
 * @author guozh
 * @create 2020-08-05 22:52
 */
@Service
public class CacheDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheDemo.class);

    private final LoadingCache<UserCacheKey , Optional<Operator>> usercache = CacheBuilder
            .newBuilder().maximumSize(500).build(new UserLoader());

    /**
     * 每天定时清理用户信息缓存
     */
    private final Runnable CACHE_CLEAN = new CacheCleaner();


    @Autowired
    private TimeCallbackService timeCallbackService;


    @PostConstruct
    public void init(){
        CACHE_CLEAN.run();
    }


    public Optional<Operator> getUserFromCache(UserCacheKey userCacheKey){
        Optional<Operator> res = Optional.empty();
        try {
            res = usercache.get(userCacheKey);
            if(!res.isPresent()){
                // 如果查询数据不存在,稍后清理掉.
                timeCallbackService.runAfter(()->usercache.invalidate(userCacheKey) , 2 , TimeUnit.SECONDS , false);
            }
            return res;
        }catch (Exception e){

            return res;
        }
    }


    private class UserLoader extends CacheLoader<UserCacheKey , Optional<Operator>> {
        @Override
        public Optional<Operator> load(UserCacheKey key) throws Exception {
            // 从一级缓存(redis)读,或者从数据库读

//            if (key.type == KeyType.LOGIN_NAME){
//                Optional.ofNullable(operatorFacade.queryByName(key.name));
//            }


            return Optional.empty();
        }
    }





    private static class UserCacheKey {

        private final KeyType type;
        private final String name;

        private UserCacheKey(KeyType type , String name){
            this.type = type;
            this.name = name;
        }
    }

    public static enum KeyType{

        NICK,

        STAFF_ID,

        LOGIN_NAME,

        ;
        public static KeyType getType(String name){
            for (KeyType keyType : KeyType.values()) {
                if(keyType.name().equals(name)){
                    return keyType;
                }
            }
            return null;
        }

    }

    private class CacheCleaner implements Runnable {
        @Override
        public void run() {
            try {
                USER_CACHE_CLEAN_EXECUTOR.run();
            }finally {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY , 32);
                calendar.set(Calendar.MINUTE , 3);
                calendar.set(Calendar.SECOND , 1);
                long experedTime = calendar.getTimeInMillis();
                long delay = experedTime - System.currentTimeMillis();
                timeCallbackService.runAfter(this , delay , TimeUnit.MILLISECONDS , true);
            }
        }
    }

    private final Runnable USER_CACHE_CLEAN_EXECUTOR = ()->{
        this.usercache.invalidateAll();
    };
}