package com.guoguo.javaAudition.guava;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 描述:
 * 拆分string去除空值
 *
 * @author guozh
 * @create 2019-09-22 17:45
 */
@Slf4j
public class SplitterTest {

    public static void main(String[] args) {

        String a = ",a,,b,";

        String[] split = a.split(",");
        log.info("原生split拆分: {}", Lists.newArrayList(split));  // 结果["","a","","b"]

        // Guava拆分
        List<String> splitGuava = Splitter.on(",")
                .omitEmptyStrings()   // 去掉空值
                .trimResults()   // 默认去掉首尾的空格
                .splitToList(a);
        log.info("guava的split拆分: {}" , splitGuava); // ["a","b  c"]


    }

}