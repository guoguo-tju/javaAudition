package com.guoguo.javaAudition;

import com.guoguo.javaAudition.common.DateUtils;
import com.guoguo.javaAudition.job.TimeCallbackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-06-26 18:42
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JavaAuditionApplication.class)
public class TimeCallbackTest{


    @Autowired
    private TimeCallbackService timeCallbackService;

    @Test
    public void test01(){

        System.out.println("开始时间: " + DateUtils.getCurTime());
        timeCallbackService.runAfter(()->{
            System.out.println("执行时间：" + DateUtils.getCurTime());
        } , 3 , TimeUnit.SECONDS , false);

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("结束时间: " + DateUtils.getCurTime());


    }
}