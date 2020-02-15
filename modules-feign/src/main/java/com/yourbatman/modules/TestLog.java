package com.yourbatman.modules;

import com.yourbatman.modules.client.DemoClient;
import feign.Feign;
import feign.slf4j.Slf4jLogger;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {

    @Test
    public void fun1(){
        Logger logger = LoggerFactory.getLogger("【test name一般显示全类名】");
        System.out.println(logger.getClass() + "\n");

        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

    @Test
    public void fun2(){
        DemoClient client = Feign.builder()
                .logLevel(feign.Logger.Level.FULL).logger(new Slf4jLogger())
                .target(DemoClient.class, "http://localhost:8080");

        client.getDemo1("YourBatman");

    }

}
