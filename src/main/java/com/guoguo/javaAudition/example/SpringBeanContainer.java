package com.guoguo.javaAudition.example;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import javax.lang.model.element.TypeElement;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 描述:
 * 获取spring初始化后的一些bean , 进行某些注册操作
 *
 * @author guozh
 * @create 2020-03-28 22:22
 */
public class SpringBeanContainer implements BeanFactoryAware , BeanPostProcessor {

    private final ConcurrentMap<String , SpringBeanInterface> container = Maps.newConcurrentMap();


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // 增加一个beanPostProcessor的处理器 (springBeanExample类 , 这样在每一个bean实例化之后都会走一遍postProcessBeforeInitialization方法来注册进map)
        ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
        configurableBeanFactory.addBeanPostProcessor(this);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // bean初始化之后调用
        // 这里bean初始化之后如果是某个接口的实现类,则注册到相应的map里
        if (bean instanceof SpringBeanInterface){
            SpringBeanInterface springBean = (SpringBeanInterface) bean;
            String type = springBean.getType();
            // 返回原先key对应的value , 如果不为空,表示key是新增的
            SpringBeanInterface putIfAbsentBean = container.putIfAbsent(type, springBean);
            if (putIfAbsentBean != null){
                throw new RuntimeException("实现类重复定义!");
            }
        }
        return bean;
    }

    public SpringBeanInterface getBeanByType(String type){
        if (container.containsKey(type)){
            return container.get(type);
        }else {
            return null;
        }
    }
}