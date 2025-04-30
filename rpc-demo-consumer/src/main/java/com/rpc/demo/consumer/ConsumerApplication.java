package com.rpc.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Web服务消费者启动类
 */
@Slf4j
@SpringBootApplication
public class ConsumerApplication {
    
    public static void main(String[] args) {
        log.info("RPC消费者Web服务启动中...");
        SpringApplication.run(ConsumerApplication.class, args);
        log.info("RPC消费者Web服务启动完成");
    }
} 