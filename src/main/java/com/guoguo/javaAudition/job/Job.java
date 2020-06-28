package com.guoguo.javaAudition.job;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-06-28 11:35
 */
@Data
public class Job {


    private int id;


    private String jobId;

    private String type;

    private String param;

    private String machine;

    /**
     * 重试次数
     */
    private int retryTime;

    /**
     * 下次重试时间
     */
    private Date execTime;

    /**
     * 执行间隔
     */
    private int execInterval;

    /**
     * 状态 0 :正常
     * 状态 1 :失败
     */
    private int status;

    private String processorType;

}