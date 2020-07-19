package com.guoguo.javaAudition.fsm;

import com.guoguo.javaAudition.common.Log;
import com.guoguo.javaAudition.common.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-07-19 14:25
 */
@Service
public class DemoStateMachineService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoStateMachineService.class);

    private final DemoHandler demoHandler = new DemoHandler();

    private final DemoTriggerHandler demoTriggerHandler = new DemoTriggerHandler();


    /**
     * 工单状态机 : 满足工单的状态管理和流程的推动
     */
    public StateMachine<DemoEvent> getDemoStateMachine(Demo demo){

        StateMachineTemplate.Config<DemoEvent, DemoStatusEnum, Demo> config
                = new StateMachineTemplate.Config<>();

        // 全局的一些逻辑 ， 比如状态一变化就发消息通知 ， 比如更新demo的状态，记录更新时间之类
        config.enter(demoHandler).exit(demoHandler);

        config.config(DemoStatusEnum.INIT)
                .enter(demoHandler)
                .permit(DemoEvent.START , DemoStatusEnum.RUNNING)
                .permit(DemoEvent.CANCEL , DemoStatusEnum.CANCEL);

        config.config(DemoStatusEnum.RUNNING)
                .enter(demoHandler)
                .exit(demoHandler)
                .permit(DemoEvent.NEXT, DemoStatusEnum.VERIFY)
                .permit(DemoEvent.ERROR, DemoStatusEnum.FAILED)
                .permit(DemoEvent.PAUSE, DemoStatusEnum.PAUSED)
                .permit(DemoEvent.CANCEL , DemoStatusEnum.CANCEL)
                .event(DemoEvent.REDO, demoTriggerHandler);

        config.config(DemoStatusEnum.FAILED)
                .enter(demoHandler)
                .event(DemoEvent.RETRY , demoTriggerHandler)
                .permit(DemoEvent.SKIP , DemoStatusEnum.SKIPPED);

        config.config(DemoStatusEnum.PAUSED)
                .enter(demoHandler)
                .event(DemoEvent.RESUME , demoTriggerHandler)
                .permit(DemoEvent.CANCEL , DemoStatusEnum.CANCEL);

        config.config(DemoStatusEnum.VERIFY)
                .enter(demoHandler)
                .permit(DemoEvent.NEXT , DemoStatusEnum.COMPLETED)
                .permit(DemoEvent.CANCEL , DemoStatusEnum.CANCEL);

        config.config(DemoStatusEnum.SKIPPED)
                .enter(demoHandler)
                .event(DemoEvent.REDO , demoTriggerHandler);

        config.config(DemoStatusEnum.COMPLETED).enter(demoHandler);
        config.config(DemoStatusEnum.CANCEL).enter(demoHandler);

        final DemoModel demoModel = new DemoModel(demo);

        config.aroundHandler(new StateAroundHandler() {
            @Override
            public void before() {
                Log.info(LOGGER , "状态机:[{}][{}]开始运行" , demoModel.hashCode() , demoModel.getDescription());
            }

            @Override
            public void after() {
                Log.info(LOGGER , "状态机:[{}][{}]运行结束" , demoModel.hashCode() , demoModel.getDescription());
            }
        });

        return new StateMachineTemplate<DemoEvent, DemoStatusEnum , Demo>(demoModel , config);
    }

    /**
     * 工单状态模型
     */
    private static class DemoModel extends BaseStateModel<DemoStatusEnum , Demo>{

        private final Demo demo;

        DemoModel(Demo demo){
            super(demo , demo.getStatus() , ParamUtils.format("BPM工单:[{}] [{}]" , demo.getId() , demo.getName()));
            this.demo = demo;
        }

        @Override
        protected void setState(DemoStatusEnum state) {
            demo.setStatus(state);
        }
    }


    private class DemoHandler implements FsmCallback<DemoEvent , DemoStatusEnum , Demo>{
        @Override
        public void call(CallbackParam<DemoEvent, DemoStatusEnum, Demo> param) {
            Demo demo = param.getSource();
            Log.info(LOGGER , "demo[{}],状态由[{}]变为[{}]" , demo.getId() , param.getOldState() , param.getNewState());
            demo.setStatus(DemoStatusEnum.INIT);

            // ...业务逻辑

        }
    }

    private class DemoTriggerHandler extends AbstractTriggerCallback<DemoEvent , DemoStatusEnum , Demo>{
        @Override
        protected void call(TriggerCallbackParam<DemoEvent , DemoStatusEnum , Demo> param) {
            Demo demo = param.getSource();
            DemoStatusEnum oldState = param.getOldState();
            DemoStatusEnum newState = param.getNewState();

        }
    }


    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setId(111);
        demo.setName("demoName");
        demo.setStatus(DemoStatusEnum.INIT);

        DemoStateMachineService demoStateMachineService = new DemoStateMachineService();
        demoStateMachineService.getDemoStateMachine(demo).fire(DemoEvent.START);
    }

}