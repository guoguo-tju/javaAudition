package com.guoguo.javaAudition.job;

import lombok.Data;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-06-28 11:42
 */
@Data
public class TaskResult {


    private int taskId;


    private ResultCode resultCode;

    private String resultMsg;


    public static TaskResult newFailedResult(){
        return new TaskResult().setResultCode(ResultCode.FAIL);
    }

    public static TaskResult newFailedResult(String message){
        return newFailedResult().setResultMsg(message);
    }

    public static TaskResult newSuccessResult(){
        return new TaskResult().setResultCode(ResultCode.SUCCESS);
    }

    public static TaskResult newSuccessResult(String message){
        return newSuccessResult().setResultMsg(message);
    }


    public TaskResult setResultCode(ResultCode resultCode){
        this.resultCode = resultCode;
        return this;
    }

    public TaskResult setResultMsg(String resultMsg){
        this.resultMsg = resultMsg;
        return this;
    }


    public static enum ResultCode{

        SUCCESS,

        FAIL,

        WAITTING

    }
}