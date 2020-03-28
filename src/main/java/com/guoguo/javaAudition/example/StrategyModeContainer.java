package com.guoguo.javaAudition.example;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentMap;

/**
 * 描述:
 * 策略模式: 2种实现思路
 *
 * 1. 容器类利用spring的BeanFactoryAware , BeanPostProcessor方式
 * com/guoguo/javaAudition/example/SpringBeanContainer.java:21
 *
 * 2. 实现类利用@PostConstruct注解方式
 * com/guoguo/javaAudition/example/StrategyModeContainer.java:16
 *
 * @author guozh
 * @create 2020-03-28 23:19
 */
@Service
public class StrategyModeContainer {

    private final ConcurrentMap<String , SpringBeanInterface> container = Maps.newConcurrentMap();

    public void register(SpringBeanInterface bean){
        SpringBeanInterface putIfAbsentBean = this.container.putIfAbsent(bean.getType(), bean);
        if (putIfAbsentBean != null){
            throw new RuntimeException("实现类重复定义!");
        }
    }

    public SpringBeanInterface getBeanByType(String type){
        if (container.containsKey(type)){
            return container.get(type);
        }else {
            return null;
        }
    }

}