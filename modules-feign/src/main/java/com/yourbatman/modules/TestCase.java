package com.yourbatman.modules;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yourbatman.modules.beans.Person;
import com.yourbatman.modules.client.DecoderClient;
import com.yourbatman.modules.client.DemoClient;
import com.yourbatman.modules.client.JacksonDemoClient;
import feign.Feign;
import feign.Logger;
import feign.Retryer;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jackson.JacksonIteratorDecoder;
import feign.okhttp.OkHttpClient;
import feign.stream.StreamDecoder;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class TestCase {

    public static void main(String[] args) {
        DemoClient client = Feign.builder()
                .client(new OkHttpClient(myOkHttpClient())) // 显示指定使用OkHttpClient
                .target(DemoClient.class, "http://localhost:8080");

        String result = client.getDemo1("YourBatman");
        System.out.println(result);
    }


    // 项目内定制好的共用的OkHttpClient
    // 注意：它和feign.okhttp.OkHttpClient同名哦
    private static okhttp3.OkHttpClient myOkHttpClient() {
        okhttp3.OkHttpClient hc = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .followRedirects(true)
                .build();
        return hc;
    }

    @Test
    public void fun1() {
        DemoClient client = Feign.builder()
                .client(new ApacheHttpClient()) // 显示指定使用OkHttpClient
                .target(DemoClient.class, "http://localhost:8080");

        String result = client.getDemo1("YourBatman");
        System.out.println(result);
    }

    @Test
    public void fun2() {
        JacksonDemoClient client = Feign.builder()
                .logger(new Logger.ErrorLogger()).logLevel(Logger.Level.FULL).retryer(Retryer.NEVER_RETRY) // 输出日志
                .target(JacksonDemoClient.class, "http://localhost:8080");

        try {
            client.jacksonDemo1("this is http body");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.err.println(" -------------------------- ");

        try {
            client.jacksonDemo2(new Person());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun3() {
        JacksonDemoClient client = Feign.builder()
                .encoder(new JacksonEncoder())
                .logger(new Logger.ErrorLogger()).logLevel(Logger.Level.FULL).retryer(Retryer.NEVER_RETRY) // 输出日志
                .target(JacksonDemoClient.class, "http://localhost:8080");

        // client.jacksonDemo2(new Person());
        client.jacksonDemo2(null);
    }

    @Test
    public void fun4() {
        DecoderClient client = Feign.builder()
                .decoder(new JacksonDecoder())
                // .decoder(StreamDecoder.create(JacksonIteratorDecoder.create()))
                .target(DecoderClient.class, "http://localhost:8080");

        // List<String> list = client.getDemo1List();
        Stream<String> listStream = client.getDemo1List();
        System.out.println(listStream);
    }

    @Test
    public void fun5() {
        DecoderClient client = Feign.builder()
                .decoder(JacksonIteratorDecoder.create())
                .target(DecoderClient.class, "http://localhost:8080");

        Iterator<String> it = client.getDemo1List2();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}


