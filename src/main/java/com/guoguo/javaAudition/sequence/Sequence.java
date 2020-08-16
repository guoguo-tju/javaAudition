package com.guoguo.javaAudition.sequence;

import lombok.Getter;

public enum Sequence {

    BPM("bpm" , "BPM流程序号" , 500),

    DB_ID("db_id" , "DB序号" , 10)

    ;
    @Getter
    private final String name;
    @Getter
    private final String desc;
    @Getter
    private final int step;

    Sequence(String name , String desc , int step){
        this.name = name;
        this.desc = desc;
        this.step = step;
    }

}
