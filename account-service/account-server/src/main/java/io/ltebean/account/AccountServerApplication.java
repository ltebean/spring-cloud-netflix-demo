package io.ltebean.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ltebean on 16/4/1.
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan(basePackages = {"io.ltebean"})
public class AccountServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(AccountServerApplication.class, args);
    }
}
