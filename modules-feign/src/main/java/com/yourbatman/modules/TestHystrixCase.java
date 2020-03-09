package com.yourbatman.modules;

import com.yourbatman.modules.client.DemoClient;
import com.yourbatman.modules.fallback.DemoClientFallback;
import com.yourbatman.modules.fallback.DemoClientFallbackFactory;
import feign.hystrix.HystrixFeign;
import org.junit.Test;

public class TestHystrixCase {

    @Test
    public void fun1() {
        // 必须使用HystrixFeign哦
        DemoClient client = HystrixFeign.builder()
                // 指定fallback实例为DemoClientFallback
                // .target(DemoClient.class, "http://localhost:8080", new DemoClientFallback());
                .target(DemoClient.class, "http://localhost:8080", new DemoClientFallbackFactory());

        String result = client.getDemo1("YourBatman");
        System.out.println(result);
    }


}
