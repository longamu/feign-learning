package com.yourbatman.modules.client;

import com.yourbatman.modules.beans.Person;
import feign.RequestLine;

public interface JacksonDemoClient {

    @RequestLine("POST /feign/jacksondemo")
    String jacksonDemo1(String body);

    @RequestLine("POST /feign/jacksondemo")
    String jacksonDemo2(Person person);
}
