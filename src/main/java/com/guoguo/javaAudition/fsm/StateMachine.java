package com.guoguo.javaAudition.fsm;

public interface StateMachine<E extends Enum> {

    /**
     * 指定的对象状态机上发生指定的事件 , 推动状态的流转
     *
     * @param event
     */
    void fire(E event);

    /**
     * 在当前状态上发生指定类型的事件 , 不推动状态迁移 , 如果内部有状态迁移逻辑 , 可以在内部调用fire
     * @param event
     * @param param
     */
    void trigger(E event , Object param);

}
