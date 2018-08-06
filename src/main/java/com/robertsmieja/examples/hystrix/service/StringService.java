package com.robertsmieja.examples.hystrix.service;

public class StringService {
    public String helloWorld(){
        return "Hello World";
    }

    public String hello(String world){
        return "Hello " + world;
    }
}