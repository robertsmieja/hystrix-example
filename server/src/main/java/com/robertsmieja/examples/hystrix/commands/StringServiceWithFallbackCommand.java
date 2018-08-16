package com.robertsmieja.examples.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class StringServiceWithFallbackCommand extends HystrixCommand<String> {

    public StringServiceWithFallbackCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(StringServiceWithFallbackCommand.class.getSimpleName())));
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
