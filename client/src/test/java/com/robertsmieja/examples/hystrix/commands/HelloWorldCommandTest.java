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
        System.out.println(objectUnderTest.execute());
    }

    @Test
    public void aSync() throws ExecutionException, InterruptedException {
        Future<String> future = objectUnderTest.queue();
        System.out.println(future.get());
    }

}