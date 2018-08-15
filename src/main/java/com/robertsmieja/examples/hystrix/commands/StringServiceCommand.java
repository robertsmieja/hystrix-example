package com.robertsmieja.examples.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class StringServiceCommand extends HystrixCommand<String> {

    public StringServiceCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(StringServiceCommand.class.getSimpleName())));
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
