package com.guoguo.javaAudition.job;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.concurrent.ConcurrentMap;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-06-28 15:24
 */
@Service
public class JobExecutors implements BeanFactoryAware , BeanPostProcessor {

    private final ConcurrentMap<String , JobExecutor> executorMap = Maps.newConcurrentMap();

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        ConfigurableBeanFactory ctx = (ConfigurableBeanFactory)beanFactory;
        ctx.addBeanPostProcessor(this);
    }



    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof JobExecutor){
            JobExecutor executor = (JobExecutor)bean;
            String type = executor.getType();
            JobExecutor jobExecutor = executorMap.putIfAbsent(type, executor);
            Assert.isNull(jobExecutor , "Job的处理器已经存在 , type=" + type);
        }
        return bean;
    }

    public JobExecutor getExecutor(String type){
        return executorMap.get(type);
    }
}