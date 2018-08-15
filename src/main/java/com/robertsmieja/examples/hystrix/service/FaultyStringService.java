package com.robertsmieja.examples.hystrix.service;

import java.io.IOException;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@ManagedResource
@Service
public class FaultyStringService {
    private long minDelayMillis = 10;
    private long maxDelayMillis = 100;
    private long percentOfRequestsToFail = 0;

    @ManagedOperation
    public String helloWorld() throws InterruptedException, IOException {
        failRequest();
        addDelay();

        return "Hello World";
    }

    @ManagedOperation
    public String hello(String world) throws IOException, InterruptedException {
        failRequest();
        addDelay();

        return "Hello " + world;
    }

    private void failRequest() throws IOException {
        int diceRoll = RandomUtils.nextInt(0, 101);
        boolean shouldRequestFail = diceRoll < percentOfRequestsToFail;

        if (shouldRequestFail){
            throw new IOException("A real IO exception");
        }
    }

    private void addDelay() throws InterruptedException {
        long delay = RandomUtils.nextLong(minDelayMillis, maxDelayMillis + 1); //+1 due to max being exclusive
        Thread.sleep(delay);
    }

    @ManagedAttribute
    public long getMinDelayMillis() {
        return minDelayMillis;
    }

    @ManagedAttribute
    public void setMinDelayMillis(long minDelayMillis) {
        this.minDelayMillis = minDelayMillis;
    }

    @ManagedAttribute
    public long getMaxDelayMillis() {
        return maxDelayMillis;
    }

    @ManagedAttribute
    public void setMaxDelayMillis(long maxDelayMillis) {
        this.maxDelayMillis = maxDelayMillis;
    }

    @ManagedAttribute
    public long getPercentOfRequestsToFail() {
        return percentOfRequestsToFail;
    }

    @ManagedAttribute
    public void setPercentOfRequestsToFail(long percentOfRequestsToFail) {
        this.percentOfRequestsToFail = percentOfRequestsToFail;
    }
}