package com.guoguo.javaAudition.example;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-03-28 23:28
 */
public class StrategyModeServiceImpl implements SpringBeanInterface{

    @Resource
    private StrategyModeContainer strategyModeContainer;

    @PostConstruct
    public void init(){
        strategyModeContainer.register(this);
    }

    @Override
    public String getType() {
        return "strategy-mode-service";
    }

    @Override
    public void doSomething() {

    }
}