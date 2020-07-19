package com.guoguo.javaAudition.fsm;

import lombok.Data;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-07-19 14:27
 */
@Data
public class Demo {

    private long id;

    private String name;

    private DemoStatusEnum status;

}