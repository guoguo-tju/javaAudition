package com.guoguo.javaAudition.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @author guozh
 * @create 2019-02-03 22:32
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class aClass = Class.forName("com.guoguo.javaAudition.reflection.Robot");
        Robot robot = (Robot)aClass.newInstance();
        // Robot对象只能调用其公有方法 , 不能调用私有方法.

        // 通过反射调用私有方法 , 需要setAccessible为true
        // rc.getDeclaredMethod(方法名称 , 方法的参数类型) 可以获取到该类的私有和公有方法 , 但是不能获取到继承来的方法
        Method sayNameAndAge = aClass.getDeclaredMethod("sayNameAndAge" , String.class);
        sayNameAndAge.setAccessible(true);
        // invoke(类的实例化对象 , 方法参数)
        sayNameAndAge.invoke(robot , "123");

        // 通过反射调用公有方法
        // rc.getMethod(...) 不能获取到该类的私有方法 , 可以获取到该类的继承方法和实现接口的方法
        Method sayHello = aClass.getMethod("sayHello", String.class);
        sayHello.invoke(robot , "Karl");

        // 通过反射调用私有属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        // set(类的实例化对象 , 属性值)
        name.set(robot , "Karl");
        sayNameAndAge.invoke(robot , "123");

    }

}