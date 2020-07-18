package com.guoguo.javaAudition.fsm;

/**
 * 状态迁移的回调
 */
public interface FsmCallback<E extends Enum,S extends Enum , T> {

    /**
     * 回调方法
     * @param param
     */
    void call(CallbackParam<E,S,T> param);
}
