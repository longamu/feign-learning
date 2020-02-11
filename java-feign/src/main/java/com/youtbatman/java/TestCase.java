package com.youtbatman.java;

import com.youtbatman.java.client.DemoClient;
import feign.Feign;
import feign.Logger;
import feign.Retryer;

public class TestCase {

    public static void main(String[] args) {
        DemoClient client = Feign.builder()
                .logger(new Logger.ErrorLogger()).logLevel(Logger.Level.FULL)
                .retryer(Retryer.NEVER_RETRY)
                .target(DemoClient.class, "http://localhost:8080");
        String result = client.getDemo1("YourBatman");
        System.out.println(result);
    }

}


