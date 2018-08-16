package com.robertsmieja.examples.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.robertsmieja.examples.hystrix.StringServiceClient;

public class FaultyStringClientCommand extends HystrixCommand<String> {
    private final StringServiceClient stringServiceClient;
    private final String world;

    public FaultyStringClientCommand(StringServiceClient stringServiceClient, String world) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(FaultyStringClientCommand.class.getSimpleName())));
        this.stringServiceClient = stringServiceClient;
        this.world = world;
    }

    @Override
    protected String getFallback() {
        return stringServiceClient.hello("fallback " + world);
    }

    @Override
    protected String run() throws Exception {
        return stringServiceClient.faultyHello(world);
    }
}
