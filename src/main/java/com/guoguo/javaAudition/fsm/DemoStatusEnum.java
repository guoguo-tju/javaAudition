package com.guoguo.javaAudition.fsm;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-07-19 14:29
 */
public enum  DemoStatusEnum {

    INIT("INIT" , "初始化"),

    RUNNING("RUNNING" , "执行中"),

    VERIFY("VERIFY" , "验证阶段"),

    PAUSED("PAUSED" , "暂停"),

    FAILED("FAILED"  ,"失败"),

    SKIPPED("SKIPPED"  ,"跳过"),

    CANCEL("CANCEL" , "取消"),

    COMPLETED("COMPLETED" , "完成"),
    ;

    private String status;

    private String desc;



    DemoStatusEnum(String status , String desc){
        this.status = status;
        this.desc = desc;
    }


    public static DemoStatusEnum getStatus(String status){
        for (DemoStatusEnum statusEnum : DemoStatusEnum.values()) {
            if (statusEnum.getStatus().equals(status)){
                return statusEnum;
            }
        }
        return null;
    }


    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}