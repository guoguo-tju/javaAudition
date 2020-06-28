package com.guoguo.javaAudition.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.Callable;

/**
 * 描述:
 * 事务模版
 *
 * @author guozh
 * @create 2020-03-29 18:10
 */
@Service
public class TransactionTemplateServiceImpl implements TransactionTemplateService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public <T> T tx(Callable<T> c) {

        return transactionTemplate.execute((status)->{
           try {
               T o = c.call();
               return o;
           }catch (Exception e){
//               Log.error("事务处理出现异常")
               throw new RuntimeException("事务处理出现异常" , e);
           }
        });
    }

    @Override
    public void tx(Runnable r) {
        Callable callable = ()->{
            r.run();
            return null;
        };
        tx(callable);
    }


    public static interface Exector<T> extends Callable<T>{

        /**
         * 失败逻辑
         * @param e
         * @return
         */
        T onFailed(Exception e);
    }
}