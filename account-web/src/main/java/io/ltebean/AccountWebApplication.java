package io.ltebean;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.netflix.hystrix.contrib.codahalemetricspublisher.HystrixCodaHaleMetricsPublisher;
import com.netflix.hystrix.strategy.HystrixPlugins;
import io.ltebean.account.web.MetricsPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.TimeUnit;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"io.ltebean"})
//@EnableEurekaClient
//@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"io.ltebean.account.api"})
@EnableCircuitBreaker
public class AccountWebApplication {


    public static void main(String[] args) {
        SpringApplication.run(AccountWebApplication.class, args);
        MetricRegistry metrics = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(5, TimeUnit.SECONDS);

        HystrixPlugins.getInstance().registerMetricsPublisher(new HystrixCodaHaleMetricsPublisher(metrics));

//        HystrixPlugins.getInstance().registerMetricsPublisher(new MetricsPublisher());
    }

}