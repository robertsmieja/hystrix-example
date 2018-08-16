package com.robertsmieja.examples.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldWithFallbackCommand extends HystrixCommand<String> {
    private long timeToSleep = 0;
    private Exception exceptionToThrow;

    public HelloWorldWithFallbackCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(HelloWorldWithFallbackCommand.class.getSimpleName())));
    }

    public HelloWorldWithFallbackCommand(Exception exceptionToThrow) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(HelloWorldWithFallbackCommand.class.getSimpleName())));
        this.exceptionToThrow = exceptionToThrow;
    }

    public HelloWorldWithFallbackCommand(long timeToSleep) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(HelloWorldWithFallbackCommand.class.getSimpleName())));
        this.timeToSleep = timeToSleep;
    }

    @Override
    protected String run() throws Exception {
        if (exceptionToThrow != null){
            throw exceptionToThrow;
        }

        if (timeToSleep > 0) {
            Thread.sleep(timeToSleep);
        }

        return "Hello World";
    }

    @Override
    protected String getFallback() {
        return "Hello Fallback";
    }
}
