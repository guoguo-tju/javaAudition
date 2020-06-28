package com.guoguo.javaAudition.job.machine;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-06-28 16:47
 */
@Data
public class Machine {

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String machine;

    private String env;

    private String status;

    private Date lastHeartbeat;

    private String migrateMachine;


}