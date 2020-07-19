package com.guoguo.javaAudition.fsm;

import com.google.common.base.Throwables;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.guoguo.javaAudition.common.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import static com.guoguo.javaAudition.common.ParamUtils.assertNotEmpty;
import static com.guoguo.javaAudition.common.ParamUtils.assertNotNull;
import static com.guoguo.javaAudition.common.ParamUtils.assertNull;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-07-18 18:45
 */
public class StateMachineTemplate<E extends Enum , S extends Enum , T> implements StateMachine<E> {


    private static final Logger LOGGER = LoggerFactory.getLogger(StateMachineTemplate.class);

    private static final AtomicLong REQUEST_COUNTER = new AtomicLong(1);

    private static final StateAroundHandler DEFAULT = new StateAroundHandler(){

        @Override
        public void before() {

        }

        @Override
        public void after() {

        }
    };

    private final Config<E,S,T> config;
    private final T source;
    private final String description;
    private final BaseStateModel<S , T> baseStateModel;
    private final StateAroundHandler aroundHandler;
    private S initState;

    public StateMachineTemplate(final BaseStateModel<S , T> baseStateModel , final Config<E,S,T> config){
        this.config = config;
        this.source = baseStateModel.getSource();
        this.description = baseStateModel.getDescription();
        this.initState = baseStateModel.getInitState();
        this.baseStateModel = baseStateModel;
        this.aroundHandler = config.aroundHandler == null? DEFAULT: config.aroundHandler;
    }


    /**
     * 指定的对象状态机上发生指定的事件 , 推动状态的流转
     * @param event
     */
    @Override
    public void fire(E event) {
        around(new Runnable() {
            @Override
            public void run() {
                Transition<E, S, T> transition = config.stateMap.get(initState);

                assertNotNull(transition , "节点状态异常,异常原因:初始状态异常,当前状态机不支持[{}]状态,状态机[{}]" , initState , description);

                Map<E,S> oldMap = transition.map;

                S targetState = oldMap.get(event);

                assertNotNull(targetState , "状态[{}]下不允许发生事件[{}],状态机[{}]",initState , event , description);

                changeState(event , targetState);
            }
        });
    }

    /**
     * 在当前状态上发生指定类型的事件 , 不推动状态迁移 , 如果内部有状态迁移逻辑 , 可以在内部调用fire
     * @param event
     * @param triggerParam
     */
    @Override
    public void trigger(E event, Object triggerParam) {

        around(new Runnable() {
            @Override
            public void run() {
                final long requestId = REQUEST_COUNTER.getAndIncrement();

                Log.info(LOGGER , "{},状态[{}]上发生事件[{}],状态机[{}]",requestId,initState,event,description);

                Transition<E,S,T> transition = config.stateMap.get(initState);

                TriggerCallbackParam<E,S,T> param = new TriggerCallbackParam<>(source , event , initState , initState , triggerParam);

                Collection<AbstractTriggerCallback<E, S, T>> callbacks = transition.eventProcessors.get(event);

                assertNotEmpty(callbacks , "{},节点状态异常,异常原因:状态[{}]上不允许触发[{}]事件,状态机[{}]",requestId , initState , event , description);

                callback(param , callbacks);

                Log.info(LOGGER , "{},状态[{}]上发生事件[{}]处理完成,状态机[{}]" , requestId , initState , event , description);
            }
        });

    }

    private void changeState(Enum event, S targetState) {

        Transition<E,S,T> transition = config.stateMap.get(initState);
        Transition<E, S, T> newTransition = config.stateMap.get(targetState);
        assertNotNull(transition,"节点状态异常,异常原因:初始状态异常,当前状态机不支持[{}]状态,状态机[{}]" , initState , description);

        final long requestId = REQUEST_COUNTER.getAndIncrement();

        Log.info(LOGGER , "{},状态[{}]上发生事件[{}],目标状态:[{}],状态机[{}]" , requestId , initState , event , targetState , description);

        CallbackParam param = new CallbackParam<>(source, event, initState, targetState);
        callback(param , transition.exitCallbacks);
        callback(param , config.exitCallbacks);

        callback(param , config.enterCallbacks);
        callback(param , newTransition.enterCallbacks);

        this.baseStateModel.setState(targetState);
        Enum srcState = this.initState;
        this.initState = targetState;

        Log.info(LOGGER , "{},状态[{}]上发生事件[{}]处理完成,新状态:[{}],状态机[{}]" , requestId , srcState , event , targetState , description);

    }

    private void callback(CallbackParam param, Iterable<? extends FsmCallback<E,S,T>> callbacks) {
        for (FsmCallback<E, S, T> callback : callbacks) {
            try {
                callback.call(param);
            }catch (Exception e){
                Log.error(LOGGER , e , "调用回调[{}]发生异常,状态机[{}]" , callback , description);
                throw Throwables.propagate(e);
            }
        }

    }


    private void around(Runnable r){
        new Around(aroundHandler , r).run();
    }

    private static class Around{

        private final Runnable r;
        private final StateAroundHandler handler;

        Around(StateAroundHandler handler , Runnable r){
            this.handler = handler;
            this.r = r;
        }

        void run(){
            handler.before();
            try {
                r.run();
            }finally {
                handler.after();
            }
        }

    }


    /**
     * 状态机配置
     * @param <E>
     * @param <S>
     * @param <T>
     */
    public static class Config<E extends Enum, S extends Enum, T> {

        private final List<FsmCallback<E,S,T>> enterCallbacks = Lists.newArrayList();
        private final List<FsmCallback<E,S,T>> exitCallbacks = Lists.newArrayList();
        private final ConcurrentMap<S , Transition<E,S,T>> stateMap = Maps.newConcurrentMap();

        private StateAroundHandler aroundHandler;

        /**
         * 状态机迁移拦截器
         */
        public Config<E,S,T> aroundHandler(StateAroundHandler aroundHandler){
            assertNull(this.aroundHandler , "当前around handler已配置,请勿重复配置");
            this.aroundHandler = aroundHandler;
            return this;
        }

        /**
         * 全局开始回调
         */
        public Config<E,S,T> enter(FsmCallback<E,S,T> callback){
            enterCallbacks.add(callback);
            return this;
        }

        /**
         * 全局结束回调
         */
        public Config<E,S,T> exit(FsmCallback<E,S,T> callback){
            exitCallbacks.add(callback);
            return this;
        }

        /**
         * 生成/获取一条状态的信息
         */
        public Transition<E,S,T> config(S state){
            Transition<E,S,T> transition = stateMap.get(state);
            if (transition == null){
                transition = new Transition<E,S,T>(state);
                Transition<E,S,T> old = stateMap.putIfAbsent(state , transition);
                return old == null ? transition : old;
            }
            return transition;
        }


    }



    /**
     * 某一状态下允许发生的事件及对应的状态迁移映射关系
     * @param <E>
     * @param <S>
     * @param <T>
     */
    public static class Transition<E extends Enum, S extends Enum, T> {

        /**
         * 当前状态
         */
        private final S state;

        /**
         * 状态迁移到当前状态时的处理回调
         */
        private final List<FsmCallback<E,S,T>> enterCallbacks = Lists.newArrayList();

        /**
         * 当前状态变更为其他状态时的回调列表
         */
        private final List<FsmCallback<E,S,T>> exitCallbacks = Lists.newArrayList();

        /**
         * 当前状态上的事件,状态迁移map
         */
        private final ConcurrentMap<E,S> map = Maps.newConcurrentMap();

        /**
         * 当前状态上允许发生的固定事件及其对应的事件处理器
         */
        private final Multimap<E , AbstractTriggerCallback<E,S,T>> eventProcessors = ArrayListMultimap.create();

        Transition(final S state){
            this.state = state;
        }


        /**
         * 开始时回调
         */
        public Transition<E,S,T> enter(FsmCallback<E,S,T> callback){
            enterCallbacks.add(callback);
            return this;
        }

        /**
         * 结束时回调
         */
        public Transition<E,S,T> exit(FsmCallback<E,S,T> callback){
            exitCallbacks.add(callback);
            return this;
        }

        /**
         * 事件触发状态迁移
         */
        public Transition<E,S,T> permit(E event , S state){
            Enum old = map.putIfAbsent(event , state);
            assertNull(old , "不允许重复定义状态迁移事件:{}/{}/{}", event , state , old);
            return this;
        }

        /**
         * 注册事件处理器
         */
        public Transition<E,S,T> event(E event , AbstractTriggerCallback<E,S,T> callback){
            eventProcessors.put(event , callback);
            return this;
        }


    }
}