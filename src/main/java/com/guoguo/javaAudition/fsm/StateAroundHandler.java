package com.guoguo.javaAudition.fsm;

/**
 * 状态迁移拦截器
 */
public interface StateAroundHandler {

    /**
     * 在状态处理逻辑之前的设置
     */
    void before();

    /**
     * 状态迁移完成之后的调用
     */
    void after();

}
