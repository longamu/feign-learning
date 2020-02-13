package com.youtbatman.java.encoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import feign.Request;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

public class MyEncoder implements Encoder {

    private static final JsonMapper MAPPER = new JsonMapper();

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        if (object != null) {
            try {
                template.body(Request.Body.bodyTemplate(MAPPER.writeValueAsString(object), StandardCharsets.UTF_8));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
}
