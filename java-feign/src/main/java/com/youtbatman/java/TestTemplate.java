package com.youtbatman.java;

import feign.CollectionFormat;
import feign.template.BodyTemplate;
import feign.template.QueryTemplate;
import feign.template.UriTemplate;
import org.junit.Test;

import java.lang.reflect.TypeVariable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTemplate {

    @Test
    public void fun1() {
        UriTemplate template = UriTemplate.create("http://example.com/{foo}", StandardCharsets.UTF_8);
        Map<String, Object> params = new HashMap<>();
        params.put("foo", "bar");
        String result = template.expand(params);
        System.out.println(result);

        System.out.println("=======================================");

        // 对斜杠不要转义
        template = UriTemplate.create("http://example.com/{empty}{foo}index.html{frag}", false, StandardCharsets.UTF_8);

        params.clear();
        // params.put("empty",null);
        params.put("foo", "houses/");
        params.put("frag", "?g=sec1.2");
        result = template.expand(params);
        System.out.println(result);
    }

    @Test
    public void fun2() {
        QueryTemplate template = QueryTemplate.create("hobby-{arg}", Arrays.asList("basket", "foot"), StandardCharsets.UTF_8);
        Map<String, Object> params = new HashMap<>();
        // params.put("arg", "1");

        String result = template.expand(params);
        System.out.println(result);


        template = QueryTemplate.create("grade", Arrays.asList("1", "2"), StandardCharsets.UTF_8, CollectionFormat.CSV);
        System.out.println(template);
    }

    @Test
    public void fun3(){
        BodyTemplate template = BodyTemplate.create("data:{body}");

        Map<String, Object> params = new HashMap<>();
        params.put("body", "{\"name\": \"YourBatman\",\"age\": 18}");

        String result = template.expand(params);
        System.out.println(result);
    }

    public static void main(String[] args) {
        TypeVariable<Class<String>>[] typeParameters = String.class.getTypeParameters();
        System.out.println(typeParameters);
    }
}
