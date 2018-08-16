package com.robertsmieja.examples.hystrix.commands;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldWithFallbackCommandTest {
    private HelloWorldWithFallbackCommand objectUnderTest;
    private HelloWorldWithFallbackCommand objectUnderTestWithException;

    @Before
    public void setup(){
        objectUnderTest = new HelloWorldWithFallbackCommand();
        objectUnderTestWithException = new HelloWorldWithFallbackCommand(new Exception("We should fallback"));
    }

    @Test
    public void sync(){
        System.out.println(objectUnderTest.execute());
    }

    @Test
    public void syncFallback(){
        System.out.println(objectUnderTestWithException.execute());
    }

    @Test
    public void aSync() throws ExecutionException, InterruptedException {
        Future<String> future = objectUnderTest.queue();
        System.out.println(future.get());
    }

    @Test
    public void aSyncFallback() throws ExecutionException, InterruptedException {
        Future<String> future = objectUnderTestWithException.queue();
        System.out.println(future.get());
    }

}