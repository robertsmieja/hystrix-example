package com.robertsmieja.examples.hystrix.commands;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldWithFallbackCommandTest {
    private HelloWorldWithFallbackCommand objectUnderTest;
    private HelloWorldWithFallbackCommand objectUnderTestWithException;
    private HelloWorldWithFallbackCommand objectUnderTestWithTimeout;

    @Before
    public void setup(){
        objectUnderTest = new HelloWorldWithFallbackCommand();
        objectUnderTestWithException = new HelloWorldWithFallbackCommand(new Exception("We should fallback"));
        objectUnderTestWithTimeout = new HelloWorldWithFallbackCommand(10000);
    }

    @Test
    public void sync(){
        String actual = objectUnderTest.execute();
        System.out.println(actual);
        assertEquals("Hello World", actual);
    }

    @Test
    public void syncFallback_exception(){
        String actual = objectUnderTestWithException.execute();
        System.out.println(actual);
        assertEquals("Hello Fallback", actual);
    }

    @Test
    public void syncFallback_timeout(){
        String actual = objectUnderTestWithTimeout.execute();
        System.out.println(actual);
        assertEquals("Hello Fallback", actual);
    }

    @Test
    public void aSync() throws ExecutionException, InterruptedException {
        Future<String> future = objectUnderTest.queue();
        String actual = future.get();
        System.out.println(actual);
        assertEquals("Hello World", actual);
    }

    @Test
    public void aSyncFallback_exception() throws ExecutionException, InterruptedException {
        Future<String> future = objectUnderTestWithException.queue();
        String actual = future.get();
        System.out.println(actual);
        assertEquals("Hello Fallback", actual);
    }

    @Test
    public void aSyncFallback_timeout() throws ExecutionException, InterruptedException {
        Future<String> future = objectUnderTestWithTimeout.queue();
        String actual = future.get();
        System.out.println(actual);
        assertEquals("Hello Fallback", actual);
    }

}