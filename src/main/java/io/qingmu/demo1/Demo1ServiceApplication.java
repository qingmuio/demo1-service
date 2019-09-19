package io.qingmu.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Demo1ServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(Demo1ServiceApplication.class, args);
    }
}
