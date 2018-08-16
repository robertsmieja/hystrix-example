package com.robertsmieja.examples.hystrix.commands;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldCommandTest {
    private HelloWorldCommand objectUnderTest;

    @Before
    public void setup(){
        objectUnderTest = new HelloWorldCommand();
    }

    @Test
    public void sync(){
        String actual = objectUnderTest.execute();
        System.out.println(actual);
        assertEquals("Hello World", actual);
    }

    @Test
    public void aSync() throws ExecutionException, InterruptedException {
        Future<String> future = objectUnderTest.queue();
        String actual = future.get();
        System.out.println(actual);
        assertEquals("Hello World", actual);
    }
}