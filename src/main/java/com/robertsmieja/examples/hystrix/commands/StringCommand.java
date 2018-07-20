package com.robertsmieja.examples.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;

public class StringCommand extends HystrixCommand<String> {

    public StringCommand() {
        super(Setter.withGroupKey());
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
