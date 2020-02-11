package com.youtbatman.java;

import com.youtbatman.java.anno.BodyClient;
import com.youtbatman.java.anno.ParamClient;
import com.youtbatman.java.anno.RequestLineClient;
import com.youtbatman.java.beans.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestAnno {

    @Test
    public void fun1() {
        RequestLineClient client = FeignClientFactory.create(RequestLineClient.class);
        client.testRequestLine("YourBatman");
        System.err.println(" ------------------ ");
        client.testRequestLine2("YourBatman2");
        System.err.println(" ------------------ ");

        // 使用Map一次传多个请求参数
        Map<String, Object> map = new HashMap<>();
        map.put("name", "YourBatman3");
        map.put("age", Arrays.asList(16, 18, 20));
        client.testRequestLine3(map);
        System.err.println(" ------------------ ");

        try {
            client.testRequestLine4("YourBatman4");
        } catch (Exception e) {
        }
        System.err.println(" ------------------ ");

        try {
            client.testRequestLine5("YourBatman4");
        } catch (Exception e) {
        }
        System.err.println(" ------------------ ");


        try {
            client.testRequestLine8("YourBatman4", 18);
        } catch (Exception e) {
        }
    }

    @Test
    public void fun2() {
        ParamClient client = FeignClientFactory.create(ParamClient.class);
        client.testParam(new String[]{"YourBatman", "fsx"});
        System.err.println(" ------------------ ");
        client.testParam2(Arrays.asList("1", "2", "3"));
        System.err.println(" ------------------ ");

        client.testParam3("/?YourBatman/");
        System.err.println(" ------------------ ");
    }

    @Test
    public void fun3() {
        BodyClient client = FeignClientFactory.create(BodyClient.class);
        client.testBody();
        System.err.println(" ------------------ ");
        client.testBody2("my name is YourBatman");
        System.err.println(" ------------------ ");
        client.testBody3(new Person());
    }
}
