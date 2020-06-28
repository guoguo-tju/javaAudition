package com.guoguo.javaAudition.job.machine;

import java.util.function.Consumer;

public interface MachineService {

    /**
     * 注册宕机回调
     * @param key
     * @param callback
     */
    void registerDowntimeMigrationCallback(String key , Consumer<Machine> callback);


    /**
     * 执行一次心跳
     */
    void heartbeat();


}
