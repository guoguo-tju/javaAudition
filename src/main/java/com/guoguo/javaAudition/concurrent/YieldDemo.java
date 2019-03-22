package com.guoguo.javaAudition.concurrent;

/**
 * 描述:
 *
 * @author guozhaorong
 * @create 2019-03-22 11:48
 */
public class YieldDemo {
    public static void main(String[] args) {
        Runnable yieldTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                    if (i == 5) {
                        Thread.yield();
                    }
                }
            }
        };
        Thread t1 = new Thread(yieldTask, "A");
        Thread t2 = new Thread(yieldTask, "B");
        t1.start();
        t2.start();
    }
}