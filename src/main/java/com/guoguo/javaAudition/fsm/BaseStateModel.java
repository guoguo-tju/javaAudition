package com.guoguo.javaAudition.fsm;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 描述:
 *
 *  基本的状态机描述 , 用于定义一个状态的基本信息:
 *      状态机对象 , 初始状态 , 状态机描述信息以及状态改变时的回调
 *
 * @author guozh
 * @create 2020-07-18 20:45
 */
public abstract class BaseStateModel<S extends  Enum, T> {

    private final T source;

    private final S initState;

    private final String description;

    public BaseStateModel(final T source , final S initState , final String description){
        this.source = source;
        this.initState = initState;
        this.description = description;
    }

    final T getSource(){
        return source;
    }

    final S getInitState(){
        return initState;
    }


    final public String getDescription(){
        return description;
    }


    /**
     * 设置新状态
     * @param state
     */
    protected abstract void setState(S state);


}