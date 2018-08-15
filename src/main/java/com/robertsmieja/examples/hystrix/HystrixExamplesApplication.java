package com.robertsmieja.examples.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.EnableMBeanExport;

@EnableMBeanExport
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixExamplesApplication.class, args);
    }
}
