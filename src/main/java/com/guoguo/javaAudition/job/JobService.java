package com.guoguo.javaAudition.job;

public interface JobService {



    void submitJob(Job job);

    void submitUpdateResultJob(TaskResult taskResult);

}
