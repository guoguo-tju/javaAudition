package com.guoguo.javaAudition;

import com.guoguo.javaAudition.job.Job;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 描述:
 *
 * @author guozh
 * @create 2019-02-07 17:50
 * <p>
 * 元空间 :
 * Class : HelloWorld - Method : sayHello/setName/main - Field : name
 * Class : System
 * <p>
 * Java堆 :
 * Object : String( "test" )
 * Object :  HelloWorld
 * <p>
 * 线程独占 (栈) :
 * 局部变量 test , 保存String 对象的引用 .
 * 局部变量 hw , 保存HelloWorld 对象的引用 .
 * 局部变量 a , 保存的常量 1 .
 * 代码的行号
 */
public class HelloWorld {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("hello " + name);
    }

    public static void main(String[] args) {
  /*      int a = 1;
        HelloWorld hw = new HelloWorld();
        hw.setName("test");
        hw.sayHello();*/
        String a = "a";
        String b = "a";
        System.out.println(a == b);
        String c = new String("c");
        String d = new String("c");
        System.out.println(c == d);


        PriorityQueue<Job> objects = new PriorityQueue<>(5, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.getId() - o2.getId();
            }
        });

        double cc = 0.03 - 0.02;
        System.out.println("cc = " + cc);
    }

}