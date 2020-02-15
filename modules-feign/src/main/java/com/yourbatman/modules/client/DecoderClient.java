package com.yourbatman.modules.client;

import com.yourbatman.modules.beans.Person;
import feign.RequestLine;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface DecoderClient {

    // @RequestLine("GET /feign/demo1/list")
    // List<String> getDemo1List();

    @RequestLine("GET /feign/demo1/list")
    Stream<String> getDemo1List();

    @RequestLine("GET /feign/demo1/list")
    Iterator<String> getDemo1List2();


    /**
     * 查询列表
     */
    @RequestLine("GET /person/list")
    List<Person> getList();

    /**
     * 新增一条记录
     */
    @RequestLine("POST /person")
    Long create(Person person);
}
