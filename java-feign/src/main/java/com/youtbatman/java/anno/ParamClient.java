package com.youtbatman.java.anno;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 测试注解的使用
 */
public interface ParamClient {

    // 1、参数为数组类型
    @RequestLine("GET /feign/demo2?name={name}")
    String testParam(@Param("name") String[] names);

    // 2、参数为List类型
    @RequestLine("GET /feign/demo2?name={name}")
    String testParam2(@Param("name") Collection<String> names);


    // 3、参数值包含特殊字符：? / 这种
    @RequestLine("GET /feign/demo2?name={name}")
    String testParam3(@Param("name") String name);
}
