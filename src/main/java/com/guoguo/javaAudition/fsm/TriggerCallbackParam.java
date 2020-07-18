package com.guoguo.javaAudition.fsm;

import javax.jws.Oneway;

/**
 * 描述:
 *
 *  状态机上触发事件回调的参数
 *
 * @author guozh
 * @create 2020-07-18 21:23
 */
public class TriggerCallbackParam<E extends Enum , S extends Enum , T> extends CallbackParam<E,S,T>{


    /**
     * 状态机迁移参数
     */
    private final Object param;

    public TriggerCallbackParam(T source, E event, S oldState, S newState, Object param) {
        super(source, event, oldState, newState);
        this.param = param;
    }

    public TriggerCallbackParam(final CallbackParam<E,S,T> callbackParam , final Object param){
        super(callbackParam);
        this.param = param;
    }

    public <P> P getParam(){
        return (P)param;
    }

}