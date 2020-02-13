package com.youtbatman.java;

import com.youtbatman.java.beans.Person;
import com.youtbatman.java.encoder.EncoderClient;
import org.junit.Test;

public class TestEncoder {

    @Test
    public void fun1(){
        EncoderClient client = FeignClientFactory.create(EncoderClient.class);

        client.encoderDemo1("YourBatman1", 18);
        System.err.println(" ------------------------- ");

        try { client.encoderDemo2("YourBatman2", 18); }catch (Exception e) {e.printStackTrace();}
        System.err.println(" ------------------------- ");

        try { client.encoderDemo3("YourBatman3", 18); }catch (Exception e) {e.printStackTrace();}
        System.err.println(" ------------------------- ");

        try { client.encoderDemo4("YourBatman4"); }catch (Exception e) {e.printStackTrace();}
        System.err.println(" ------------------------- ");

        try { client.encoderDemo5("YourBatman5"); }catch (Exception e) {e.printStackTrace();}
        System.err.println(" ------------------------- ");

        try { client.encoderDemo6(new Person()); }catch (Exception e) {e.printStackTrace();}
        System.err.println(" ------------------------- ");

        try { client.encoderDemo7(new Person()); }catch (Exception e) {e.printStackTrace();}
    }

    @Test
    public void fun2(){
        EncoderClient client = FeignClientFactory.create(EncoderClient.class);
        client.queryMapEncoderDemo1(new Person());
    }

}
