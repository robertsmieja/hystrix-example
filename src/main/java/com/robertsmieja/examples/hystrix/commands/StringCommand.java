package com.robertsmieja.examples.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class StringCommand extends HystrixCommand<String> {

    public StringCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("foo")));
    }

    @Override
    protected String getFallback() {
        return "Fallback";
    }

    @Override
    protected String run() throws Exception {
        return "Hello World";
    }
}
