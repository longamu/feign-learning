package com.yourbatman.modules.fallback;

import com.yourbatman.modules.client.DemoClient;

public class DemoClientFallback implements DemoClient {
    @Override
    public String getDemo1(String name) {
        return "this are fallback info...";
    }
}
