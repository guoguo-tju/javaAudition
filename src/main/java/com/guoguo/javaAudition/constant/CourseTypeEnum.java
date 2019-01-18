package com.guoguo.javaAudition.constant;

public enum CourseTypeEnum {

    VIDEO_COURSE(1, "录制课程"),

    LIVE_COURSE(2, "在线课程"),

    OFFLINE_COURSE(3, "线下课程");


    private Integer courseType;
    private String courseDesc;

    CourseTypeEnum(Integer courseType, String courseDesc) {
        this.courseType = courseType;
        this.courseDesc = courseDesc;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }
}
