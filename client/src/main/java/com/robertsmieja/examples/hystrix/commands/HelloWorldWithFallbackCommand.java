package com.robertsmieja.examples.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldWithFallbackCommand extends HystrixCommand<String> {
    private Exception exceptionToThrow;

    public HelloWorldWithFallbackCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(HelloWorldWithFallbackCommand.class.getSimpleName())));
    }

    HelloWorldWithFallbackCommand(Exception exceptionToThrow) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(HelloWorldWithFallbackCommand.class.getSimpleName())));
        this.exceptionToThrow = exceptionToThrow;
    }

    @Override
    protected String run() throws Exception {
        if (exceptionToThrow != null){
            throw exceptionToThrow;
        }
        return "Hello World";
    }

    @Override
    protected String getFallback() {
        return "Hello Fallback";
    }
}
