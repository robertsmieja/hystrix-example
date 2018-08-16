package com.robertsmieja.examples.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldCommand extends HystrixCommand<String> {

    public HelloWorldCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(HelloWorldCommand.class.getSimpleName())));
    }

    @Override
    protected String run() throws Exception {
        return "Hello World";
    }
}
