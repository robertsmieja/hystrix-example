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
public class HystrixServerApplication {

    public static void main(String[] args) {
//        HystrixPlugins.getInstance().registerMetricsPublisher(HystrixServoMetricsPublisher.getInstance()); //Add metrics to JMX
        SpringApplication.run(HystrixServerApplication.class, args);
    }
}
