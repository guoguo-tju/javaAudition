package com.guoguo.javaAudition.common;

import lombok.Data;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-07-20 10:05
 */
@Data
public class CommonDataResult<T> {


    /**
     * 操作结果
     */
    private boolean success;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;


    /**
     * 创建成功的响应
     */
    public static <T> CommonDataResult<T> successCommonDataResult(T data){
        CommonDataResult<T> result = new CommonDataResult<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> CommonDataResult<T> successCommonDataMsg(String message){
        CommonDataResult<T> result = new CommonDataResult<T>();
        result.setSuccess(true);
        result.setMessage(message);
        return result;
    }

    public static <T> CommonDataResult<T> successCommonDataResultWithData(String message , T data){
        CommonDataResult<T> result = new CommonDataResult<>();
        result.setSuccess(true);
        result.setMessage(message);
        result.setData(data);
        return result;
    }


    /**
     * 创建失败的返回结果
     */
    public static <T> CommonDataResult<T> failCommonDataResult(String message){
        CommonDataResult<T> result = new CommonDataResult<>();
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }

    public static <T> CommonDataResult<T> failCommonDataResultWithData(String message , T data){
        CommonDataResult<T> result = new CommonDataResult<>();
        result.setSuccess(false);
        result.setMessage(message);
        result.setData(data);
        return result;
    }


}