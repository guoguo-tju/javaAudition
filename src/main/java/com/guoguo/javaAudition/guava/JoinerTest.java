package com.guoguo.javaAudition.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 * 合并字符串
 *
 * @author guozh
 * @create 2019-09-22 18:12
 */
@Slf4j
public class JoinerTest {

    public static void main(String[] args) {

        // String.join 的两个缺点: 1.不支持一次join多个字符串,后一次join会把前一次覆盖  2.如果join的是一个list,无法过滤到null值

        // Guava的API
        String join = Joiner.on(",").skipNulls().join("karl", null, "awesome");
        log.info("一次join多个字符串: {}", join);

        String join1 = Joiner.on(",").skipNulls().join(Lists.newArrayList("karl", null, "awesome"));
        log.info("自动去除list中空值: {}", join1);


    }

}