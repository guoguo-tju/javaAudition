package com.guoguo.javaAudition.job;

public interface JobExecutor {

    String getType();

    boolean doJob(Job job);

}
