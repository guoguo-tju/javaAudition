package com.guoguo.javaAudition.job;

import java.util.concurrent.TimeUnit;

public interface TimeCallbackService {


    /**
     * 在指定时间之后进行回调 , 根据override参数判断是否需要覆盖之前的任务
     * @param runnable
     * @param timeout
     * @param tm
     * @param override
     */
    void runAfter(Runnable runnable , long timeout , TimeUnit tm , boolean override);

}
