package com.guoguo.javaAudition.fsm;

/**
 * 描述:
 *  状态迁移参数对象
 *
 * @author guozh
 * @create 2020-07-18 20:58
 */
public class CallbackParam<E extends Enum, S extends Enum, T> {

    /**
     * 事件源
     */
    private final T source;

    /**
     * 事件
     */
    private final E event;

    /**
     * 原始状态
     */
    private final S oldState;

    /**
     * 事件发生后的目标状态
     */
    private final S newState;


    public CallbackParam(T source, E event, S oldState, S newState) {
        this.source = source;
        this.event = event;
        this.oldState = oldState;
        this.newState = newState;
    }

    public CallbackParam(final CallbackParam<E,S,T> param){
        this.source = param.getSource();
        this.event = param.event;
        this.oldState = param.getOldState();
        this.newState = param.getNewState();
    }

    public T getSource() {
        return source;
    }

    public E getEvent() {
        return event;
    }

    public S getOldState() {
        return oldState;
    }

    public S getNewState() {
        return newState;
    }
}