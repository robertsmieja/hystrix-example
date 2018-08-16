package com.robertsmieja.examples.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Service;

@Service
@ShellComponent
public class StringService {
    @Autowired
    private final StringServiceClient stringServiceClient;

    public StringService(StringServiceClient stringServiceClient) {
        this.stringServiceClient = stringServiceClient;
    }

    @ShellMethod("Ping command for normal StringService")
    String test() {
        return stringServiceClient.test();
    }

    @ShellMethod("Ping command for faulty StringService")
    String faultyTest() {
        return stringServiceClient.faultyTest();
    }

    @ShellMethod("HelloWorld for StringService")
    String helloWorld() {
        return stringServiceClient.helloWorld();
    }

    @ShellMethod("HelloWorld for faulty StringService")
    String faultyHelloWorld() {
        return stringServiceClient.faultyHelloWorld();
    }

    @ShellMethod("Hello for StringService")
    String hello(@ShellOption String world) {
        return stringServiceClient.hello(world);
    }

    @ShellMethod("Hello for faulty StringService")
    String faultyHello(@ShellOption String world) {
        return stringServiceClient.faultyHello(world);
    }
}
