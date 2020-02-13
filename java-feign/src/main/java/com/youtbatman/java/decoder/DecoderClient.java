package com.youtbatman.java.decoder;

import feign.RequestLine;

import java.util.stream.Stream;

public interface DecoderClient {
    // 返回值为Stream类型
    @RequestLine("GET /feign/demo1/list")
    Stream<String> getDemo1List();
}
