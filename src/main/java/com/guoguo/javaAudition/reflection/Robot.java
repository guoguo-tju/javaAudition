package com.guoguo.javaAudition.reflection;

/**
 * 描述:
 *
 * @author guozh
 * @create 2019-02-03 22:29
 */
public class Robot {

    private String name;

    public void sayHello(String str) {
        System.out.println("public method : " + str);
    }

    private void sayNameAndAge(String age) {
        System.out.println("private method : " + this.name + ";" + age);
    }


}