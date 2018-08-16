package com.robertsmieja.examples.hystrix.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robertsmieja.examples.hystrix.service.FaultyStringService;
import com.robertsmieja.examples.hystrix.service.StringService;

@RestController
@RequestMapping("string")
public class StringController {
    @Autowired
    private StringService stringService;

    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    @GetMapping
    public String index(){
        return StringController.class.getSimpleName();
    }

    @GetMapping("helloWorld")
    public String helloWorld() throws IOException, InterruptedException {
        return stringService.helloWorld();
    }

    @GetMapping("hello/{world}")
    public String hello(@PathVariable String world) throws IOException, InterruptedException {
        return stringService.hello(world);
    }
}
