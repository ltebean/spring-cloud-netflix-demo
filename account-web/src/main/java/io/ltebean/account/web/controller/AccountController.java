package io.ltebean.account.web.controller;

import io.ltebean.account.api.AccountService;
import io.ltebean.account.dto.User;
import io.ltebean.account.web.controller.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/api/v1/user")
    public Response getUser() {
        User user = accountService.getTestUser();
        return new Response(user);
    }

}