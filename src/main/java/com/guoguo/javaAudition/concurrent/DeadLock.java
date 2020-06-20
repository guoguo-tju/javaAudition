package com.guoguo.javaAudition.concurrent;

/**
 * 描述:
 * 死锁
 *
 * @author guozh
 * @create 2019-12-12 21:24
 */
public class DeadLock {

    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void startThreadA(){
        Thread threadA = new Thread(){
            @Override
            public void run(){
                synchronized (lockA){
                    try{
                        Thread.sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (lockB){}
                }
            }
        };
        threadA.start();
    }

    public static void startThreadB(){
        Thread threadB = new Thread(){
            public void run(){
                synchronized (lockB){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockA){}
                }
            }

        };
        threadB.start();
    }

    public static void main(String[] args) {
        DeadLock.startThreadA();
        DeadLock.startThreadB();
    }

}