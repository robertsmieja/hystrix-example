package com.robertsmieja.examples.hystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "StringService", url = "localhost:8080")
public interface StringServiceClient {

    @GetMapping("/string")
    String test();

    @GetMapping("/faulty")
    String faultyTest();

    @GetMapping("/string/helloWorld")
    String helloWorld();

    @GetMapping("/faulty/helloWorld")
    String faultyHelloWorld();

    @GetMapping("/string/hello/{world}")
    String hello(@PathVariable("world") String world);

    @GetMapping("/faulty/hello/{world}")
    String faultyHello(@PathVariable("world") String world);

}
