package io.ltebean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"io.ltebean"})
//@EnableEurekaClient
//@EnableDiscoveryClient
//@EnableFeignClients(basePackages = {"io.ltebean.account.api"})
public class AccountWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountWebApplication.class, args);
    }

}