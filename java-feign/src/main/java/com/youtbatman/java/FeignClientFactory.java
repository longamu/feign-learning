package com.youtbatman.java;

import feign.Feign;
import feign.Logger;
import feign.Retryer;

public abstract class FeignClientFactory {
    static <T> T create(Class<T> clazz) {
        return Feign.builder()
                .logger(new Logger.ErrorLogger()).logLevel(Logger.Level.FULL)
                .retryer(Retryer.NEVER_RETRY)
                .decode404() // 把404也解码 -> 这样就不会以一场形式抛出，中断程序喽，方便我测试嘛
                .target(clazz, "http://localhost:8080");
    }
}
