package com.rpc.demo.consumer.config;

import com.rpc.client.local.LocalServiceFactory;
import com.rpc.demo.api.MatrixService;
import com.rpc.demo.api.TextService;
import com.rpc.demo.consumer.service.LocalMatrixServiceImpl;
import com.rpc.demo.consumer.service.LocalTextServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 本地服务配置类
 * 用于注册本地服务实现到RPC框架
 */
@Slf4j
@Configuration
public class LocalServiceConfig {

    @Autowired
    private LocalMatrixServiceImpl localMatrixService;
    
    @Autowired
    private LocalTextServiceImpl localTextService;
    
    @PostConstruct
    public void init() {
        // 注册本地矩阵服务
        LocalServiceFactory.registerLocalService(MatrixService.class, localMatrixService);
        log.info("本地矩阵服务注册完成");
        
        // 注册本地文本服务
        LocalServiceFactory.registerLocalService(TextService.class, localTextService);
        log.info("本地文本服务注册完成");
    }
} 