package com.guoguo.javaAudition.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:
 *  Exchanger两个线程到达同步点后 , 相互交换数据 .
 *  让男女生互换 .
 * @author guozh
 * @create 2019-02-17 17:09
 */
public class ExchangerDemo {

    public static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(()->{
            // 女生对男生说的话
            try {
                String girl = exchanger.exchange("其实我暗恋你很久了");
                System.out.println("女生说:" + girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(()->{
            System.out.println("女生慢慢从教室里走出来");
            try {
                String boy = exchanger.exchange("我喜欢你...");
                System.out.println("男生说:" + boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });




    }

}