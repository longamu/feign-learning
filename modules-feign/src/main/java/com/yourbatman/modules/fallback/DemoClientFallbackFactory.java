package com.yourbatman.modules.fallback;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.yourbatman.modules.client.DemoClient;
import feign.hystrix.FallbackFactory;

public class DemoClientFallbackFactory implements FallbackFactory<DemoClient> {

    @Override
    public DemoClient create(Throwable cause) {
        return new DemoClient() {
            @Override
            public String getDemo1(String name) {
                if (cause instanceof HystrixTimeoutException) {
                    return name + "：你执行超时了HystrixTimeoutException";
                } else {
                    return "this are fallback info...";
                }
            }
        };
    }
}
