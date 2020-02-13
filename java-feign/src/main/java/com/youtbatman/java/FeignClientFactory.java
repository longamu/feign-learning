package com.youtbatman.java;

import com.youtbatman.java.encoder.MyEncoder;
import feign.Feign;
import feign.FeignException;
import feign.Logger;
import feign.Response;
import feign.Retryer;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.querymap.BeanQueryMapEncoder;
import feign.stream.StreamDecoder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;

public abstract class FeignClientFactory {
    static <T> T create(Class<T> clazz) {
        return Feign.builder()
                .logger(new Logger.ErrorLogger()).logLevel(Logger.Level.FULL)
                .retryer(Retryer.NEVER_RETRY)
                // .encoder(new MyEncoder())
                // .queryMapEncoder(new BeanQueryMapEncoder())

                // 使用StreamDecoder做解码
                .decoder(StreamDecoder.create((response, type) -> {
                    // resultStr的值是：["A","B","C"]
                    String resultStr = Util.toString(response.body().asReader());
                    // 简单处理，直接逗号分隔
                    return Arrays.asList(resultStr.split(",")).iterator();
                }))
                .decode404() // 把404也解码 -> 这样就不会以一场形式抛出，中断程序喽，方便我测试嘛
                .target(clazz, "http://localhost:8080");
    }
}
