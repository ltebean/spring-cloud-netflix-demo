package io.ltebean.client;

import io.ltebean.account.api.AccountService;
import io.ltebean.account.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"io.ltebean.account.api"})
@ComponentScan()
@RestController
public class ClientServerApplication {

    @Autowired
    AccountService accountService;

    @RequestMapping("/user")
    public User getUser() {
        return accountService.getTestUser();
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientServerApplication.class, args);
    }

}