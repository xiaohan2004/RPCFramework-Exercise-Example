package com.rpc.demo.provider;

import com.rpc.demo.provider.service.MatrixServiceImpl;
import com.rpc.demo.provider.service.TextServiceImpl;
import com.rpc.server.RpcServer;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务提供者启动类
 */
@Slf4j
public class ProviderApplication {
    
    public static void main(String[] args) {
        // 创建RPC服务器
        RpcServer server = new RpcServer();
        
        // 注册服务
        server.registerService(new MatrixServiceImpl());
        server.registerService(new TextServiceImpl());
        
        log.info("RPC服务提供者启动中...");
        System.out.println("RPC服务提供者启动中...");
        
        // 启动服务器
        server.start();
    }
} 