package com.youtbatman.java;

import com.youtbatman.java.decoder.DecoderClient;
import feign.Feign;
import feign.Logger;
import feign.Retryer;
import feign.Util;
import feign.stream.StreamDecoder;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

public class TestDecoder {

    @Test
    public void fun1() {
        DecoderClient client = Feign.builder()
                .logger(new Logger.ErrorLogger()).logLevel(Logger.Level.FULL)
                .retryer(Retryer.NEVER_RETRY)

                // 自定义一个临时的iterator解码器来实现
                .decoder(StreamDecoder.create((response, type) -> {
                    // resultStr的值是：["A","B","C"]
                    String resultStr = Util.toString(response.body().asReader());
                    // 简单处理，直接逗号分隔
                    return Arrays.asList(resultStr.split(",")).iterator();
                }))
                .target(DecoderClient.class, "http://localhost:8080");

        Stream<String> result = client.getDemo1List();
        result.forEach(System.out::println);
    }

    @Test
    public void fun2(){
        Method[] methods = Map.class.getMethods();
        Arrays.stream(methods).forEach(System.out::println);
    }

}
