package com.guoguo.javaAudition;

/**
 * 描述:
 *
 * @author guozh
 * @create 2019-02-07 17:50
 *
 *  元空间 :
 * Class : HelloWorld - Method : sayHello/setName/main - Field : name
 * Class : System
 *
 * Java堆 :
 * Object : String( "test" )
 * Object :  HelloWorld
 *
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
        int a = 1;
        HelloWorld hw = new HelloWorld();
        hw.setName("test");
        hw.sayHello();
    }

}