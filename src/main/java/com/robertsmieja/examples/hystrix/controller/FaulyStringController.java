package com.robertsmieja.examples.hystrix.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robertsmieja.examples.hystrix.service.FaultyStringService;

@RestController
@RequestMapping("faulty")
public class FaulyStringController {
    @Autowired
    private FaultyStringService faultyStringService;

    public FaulyStringController(FaultyStringService faultyStringService) {
        this.faultyStringService = faultyStringService;
    }

    @GetMapping
    public String index(){
        return FaulyStringController.class.getSimpleName();
    }

    @GetMapping("helloWorld")
    public String helloWorld() throws IOException, InterruptedException {
        return faultyStringService.helloWorld();
    }

    @GetMapping("hello/{world}")
    public String hello(@PathVariable String world) throws IOException, InterruptedException {
        return faultyStringService.hello(world);
    }
}
