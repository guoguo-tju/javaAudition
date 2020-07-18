package com.guoguo.javaAudition.fsm;

/**
 * 描述:
 *
 *     状态机上触发事件时的回调(trigger方法)
 *
 * @author guozh
 * @create 2020-07-18 21:20
 */
public abstract class AbstractTriggerCallback<E extends Enum, S extends Enum, T> implements FsmCallback<E,S,T> {

    @Override
    public void call(final CallbackParam<E,S,T> param){
        call(TriggerCallbackParam.class.cast(param));
    }


    /**
     * 回调方法
     */
    protected abstract void call(TriggerCallbackParam<E,S,T> param);

}