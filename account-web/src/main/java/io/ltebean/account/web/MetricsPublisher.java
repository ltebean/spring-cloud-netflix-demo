package io.ltebean.account.web;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisherCommand;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisherCommandDefault;

import java.util.concurrent.*;

/**
 * Created by leo on 2017/8/21.
 */
public class MetricsPublisher extends HystrixMetricsPublisher {


    public HystrixMetricsPublisherCommand getMetricsPublisherForCommand(HystrixCommandKey commandKey, HystrixCommandGroupKey commandGroupKey, HystrixCommandMetrics metrics, HystrixCircuitBreaker circuitBreaker, HystrixCommandProperties properties) {
        return new MetricsPublisherCommand(commandKey, commandGroupKey, metrics, circuitBreaker, properties);
    }

    public static class MetricsPublisherCommand implements HystrixMetricsPublisherCommand {

        HystrixCommandMetrics metrics;

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

        public MetricsPublisherCommand(HystrixCommandKey commandKey, HystrixCommandGroupKey commandGroupKey, HystrixCommandMetrics metrics, HystrixCircuitBreaker circuitBreaker, HystrixCommandProperties properties) {
            this.metrics = metrics;
            System.out.println(commandKey);
            System.out.println(metrics.getExecutionTimeMean());
        }

        @Override
        public void initialize() {
            // do nothing by default
            executor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println(metrics.getExecutionTimeMean());
                }
            }, 1, 1, TimeUnit.SECONDS);

        }

    }
}


