package com.guoguo.javaAudition;

import com.guoguo.javaAudition.constant.CourseTypeEnum;

/**
 * @program: javaAudition
 * @description:
 * @author: Karl Guo
 * @create: 2019-01-18 10:40
 **/
public class CourseTypeEnumTest {


    public static void main(String[] args) {

        Integer courseType = CourseTypeEnum.LIVE_COURSE.getCourseType();
        System.out.println(courseType);


    }

}
