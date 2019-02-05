package com.guoguo.javaAudition.classLoader;

/**
 * 描述:
 *
 * @author guozh
 * @create 2019-02-04 12:09
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 加载自定义的类加载器
        MyClassLoader m = new MyClassLoader("C:\\Users\\guozh\\Desktop\\");
        // 类加载器调用loadClass , 会调用到我们重写的findClass方法 , 加载我们指定的Robot类
        Class<?> c = m.loadClass("Robot");
        System.out.println(c.getClassLoader());
        Object o = c.newInstance();
    }

}