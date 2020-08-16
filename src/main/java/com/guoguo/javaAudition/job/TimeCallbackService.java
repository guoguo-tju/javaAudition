package com.guoguo.javaAudition.job;

import java.util.concurrent.Callable;
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

    /**
     * 目标方法立即执行,等待超过指定时间 或者执行出错返回默认值.
     * @param target
     * @param defaultValue
     * @param timeout
     * @param tm
     * @param <T>
     * @return
     */
    <T> T wait(Callable<T> target , T defaultValue , long timeout , TimeUnit tm);

}
