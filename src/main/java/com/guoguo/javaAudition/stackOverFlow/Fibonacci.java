package com.guoguo.javaAudition.stackOverFlow;

/**
 * 描述:
 *
 * @author guozh
 * @create 2019-02-06 21:14
 */
public class Fibonacci {

    // 什么是斐波那契函数 ?
    //F(0) = 0 , F(1) = 1 , 当你>= 2 时 , F(n) = F( n - 1 ) + F( n - 2 );
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(9000000));
    }

}