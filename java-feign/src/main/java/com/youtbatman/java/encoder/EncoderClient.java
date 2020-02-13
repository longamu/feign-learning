package com.youtbatman.java.encoder;

import com.youtbatman.java.beans.Person;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface EncoderClient {

    // 1、都标注有@Param注解，并且并且并且都被模版使用了
    @RequestLine("POST /{name}/{age}")
    String encoderDemo1(@Param("name") String name, @Param("age") Integer age);

    // 2、都标注有@Param注解，但模版只使用一个
    @RequestLine("POST /{name}")
    String encoderDemo2(@Param("name") String name, @Param("age") Integer age);

    // 3、都标注有@Param注解，但模版都没有使用
    @RequestLine("POST /")
    String encoderDemo3(@Param("name") String name, @Param("age") Integer age);

    // 4、不标注@Pram注解，是String类型
    @RequestLine("POST /")
    String encoderDemo4(String name);

    // 5、不标注@Pram注解，是Object类型，但实际传String类型
    @RequestLine("POST /")
    String encoderDemo5(Object name);

    // 6、不标注@Pram注解，是POJO
    @RequestLine("POST /")
    String encoderDemo6(Person person);

    // 6、标注@Pram注解，是POJO
    @RequestLine("POST /")
    String encoderDemo7(@Param("person") Person person);


    // ********************** 测试QueryMapEncoder
    @RequestLine("GET /")
    String queryMapEncoderDemo1(@QueryMap Person person);

}
