package com.robertsmieja.examples.hystrix.service;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@ManagedResource
@Service
public class SlowStringService {
    @ManagedOperation
    public String helloWorld() {
        return "Hello World";
    }

    @ManagedOperation
    public String hello(String world) {
        return "Hello " + world;
    }
}