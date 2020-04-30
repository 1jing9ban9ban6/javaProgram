package com.jing.weiming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jing
 * @create 2020-03-27-11:08
 */
@SpringBootApplication
@EnableEurekaClient
public class TimeServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimeServerApplication.class, args);
    }
}
