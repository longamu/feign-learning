package com.youtbatman.java.client;

import feign.Feign;
import feign.Param;
import feign.RequestLine;

public interface DemoClient {

    @RequestLine("GET /feign/demo1?name={name}")
    String getDemo1(@Param("name") String name);

    public static void main(String[] args) {
        DemoClient client = Feign.builder().target(DemoClient.class, "http://localhost:8080");
        String result = client.getDemo1("YourBatman");
        System.out.println(result);
    }
}
