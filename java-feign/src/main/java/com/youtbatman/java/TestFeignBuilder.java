package com.youtbatman.java;

import com.youtbatman.java.client.DemoClient;
import feign.Feign;
import feign.Logger;
import feign.Target;
import org.junit.Test;

public class TestFeignBuilder {

    @Test
    public void fun1() {
        Feign feign = Feign.builder().logLevel(Logger.Level.FULL).build();
        DemoClient client = feign.newInstance(new Target.HardCodedTarget<>(DemoClient.class, "http://localhost:8080"));
        System.out.println(client);
    }

    @Test
    public void fun2(){
        DemoClient client = Feign.builder().target(DemoClient.class, "http://localhost:8080");
        System.out.println(client);
    }


}
