package com.rpc.demo.consumer.service;

import com.rpc.client.RpcClient;
import com.rpc.core.annotation.RpcReference;
import com.rpc.demo.api.MatrixService;
import com.rpc.demo.api.TextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * RPC服务引用
 * 用于引入远程服务
 */
@Slf4j
@Component
public class RpcServiceReference {

    @RpcReference(version = "1.0.0")
    private MatrixService matrixService;

    @RpcReference(version = "1.0.0")
    private TextService textService;

    @PostConstruct
    public void init() {
        // 初始化RPC服务引用
        RpcClient.inject(this);
        log.info("RPC服务引用初始化完成");
    }

    /**
     * 获取矩阵服务
     */
    public MatrixService getMatrixService() {
        return matrixService;
    }

    /**
     * 获取文本服务
     */
    public TextService getTextService() {
        return textService;
    }
} 