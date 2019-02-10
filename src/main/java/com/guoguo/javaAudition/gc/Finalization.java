package com.guoguo.javaAudition.gc;

/**
 * 描述:
 * Object的finalize()方法的作用是否与C++的析构函数作用相同
 *
 * @author guozh
 * @create 2019-02-10 16:33
 */

public class Finalization {


    public static Finalization finalization;

    @Override
    protected void finalize() {
        System.out.println("into finalize");
        finalization = this;
    }

    public static void main(String[] args) {
        Finalization f = new Finalization();
        System.out.println("first print: " + f);
        f = null;
        // gc()会调用我们重写的finalize()方法
        System.gc();
        System.out.println("second print: " + f);
        System.out.println(f.finalization);

    }

}