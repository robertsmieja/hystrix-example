package com.robertsmieja.examples.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldWithFallback extends HystrixCommand<String> {

    public HelloWorldWithFallback() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(HelloWorldWithFallback.class.getSimpleName())));
    }

    @Override
    protected String run() throws Exception {
        return "Hello World";
    }
}
