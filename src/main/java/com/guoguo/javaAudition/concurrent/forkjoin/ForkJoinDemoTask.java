package com.guoguo.javaAudition.concurrent.forkjoin;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 描述:
 *
 * 使用fork-join框架 :
 *  1.首先创建一个ForkJoin任务 , 框架提供了两个子类:
 *  RecursiveAction(没有返回结果的任务) 和 RecursiveTask(又返回结果的任务)
 *
 *  2. ForkJoinTask需要通过ForkJoinPool来执行 , 其中实现了工作窃取算法.
 *
 *
 * @author guozh
 * @create 2020-06-20 21:19
 */
public class ForkJoinDemoTask extends RecursiveTask<List<String>> {

    private List<String> ipList;

    public ForkJoinDemoTask(List<String> ipList){
        this.ipList = ipList;
    }


    @Override
    protected List<String> compute() {

        List<String> result = Lists.newArrayList();

        // 如果size小于等于3 , 直接执行 , 如果大于3 , 以3为一组分成多个线程来执行

        if (ipList.size() <= 3){
            result.add("ip执行成功");
        }else {
            // 如果任务大于阈值 ， 就分成两个子任务来计算
            List<List<String>> lists = averageAssign(ipList, 2);
            List<String> leftList = lists.get(0);
            List<String> rightList = lists.get(1);
            ForkJoinDemoTask leftTask = new ForkJoinDemoTask(leftList);
            ForkJoinDemoTask rightTask = new ForkJoinDemoTask(rightList);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待子任务执行完得到结果
            List<String> join1 = leftTask.join();
            List<String> join2 = rightTask.join();
            result.addAll(join1);
            result.addAll(join2);
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> strings = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7");
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 生成一个计算任务
        ForkJoinDemoTask forkJoinDemoTask = new ForkJoinDemoTask(strings);
        ForkJoinTask<List<String>> result = forkJoinPool.submit(forkJoinDemoTask);
        try {
            System.out.println("result.get() ： " + result.get());
        }catch (Exception e){
            System.out.println("e ： " + Throwables.getStackTraceAsString(e));
        }

    }



    /**
     * 按指定大小，分隔集合，将集合按规定个数分为n个部分
     *
     * @param list
     * @param len
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, int len) {
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }

        List<List<T>> result = new ArrayList<List<T>>();


        int size = list.size();
        int count = (size + len - 1) / len;


        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }



    /**
     * 将一个list均分成n个list,主要通过偏移量来实现的
     * @param list
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> list,int n){
        List<List<T>> result=new ArrayList<List<T>>();
        int remaider=list.size()%n;  //(先计算出余数)
        int number=list.size()/n;  //然后是商
        int offset=0;//偏移量
        for(int i=0;i<n;i++){
            List<T> value=null;
            if(remaider>0){
                value=list.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=list.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        return result;
    }



}