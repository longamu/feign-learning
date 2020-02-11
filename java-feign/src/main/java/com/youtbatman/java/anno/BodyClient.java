package com.youtbatman.java.anno;

import com.youtbatman.java.beans.Person;
import feign.Body;
import feign.Param;
import feign.RequestLine;

import java.util.Collection;

/**
 * 测试注解的使用
 */
public interface BodyClient {

    // 1、@Body里可以是写死的字符串
    @Body("{\"name\" : \"YourBatman\"}")
    @RequestLine("POST /feign/demo3")
    String testBody();

    // 2、@Body可以使用模版{} 取值
    @Body("{body}")
    @RequestLine("POST /feign/demo3")
    String testBody2(@Param("body") String name);

    // 3、@Body里取值来自于一个JavaBean
    @Body("{person}")
    @RequestLine("POST /feign/demo3")
    String testBody3(@Param("person") Person person);
}
