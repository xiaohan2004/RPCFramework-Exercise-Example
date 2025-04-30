package com.rpc.demo.registry;

import com.rpc.registry.RemoteRegistryServer;
import lombok.extern.slf4j.Slf4j;

/**
 * 注册中心启动类
 */
@Slf4j
public class RegistryApplication {
    
    public static void main(String[] args) {
        int port = 8000; // 默认端口
        boolean debug = false;
        boolean test = false;
        
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                // 参数不是端口号，可能是调试模式
                String mode = args[0].toLowerCase();
                debug = mode.contains("debug");
                test = mode.contains("test");
            }
            
            // 检查第二个参数
            if (args.length > 1) {
                String mode = args[1].toLowerCase();
                debug = debug || mode.contains("debug");
                test = test || mode.contains("test");
            }
        }
        
        // 创建并启动注册中心服务器
        RemoteRegistryServer registryServer = new RemoteRegistryServer(port);
        
        log.info("RPC注册中心启动中，端口: {}, 调试模式: {}, 测试模式: {}", port, debug, test);
        System.out.println("RPC注册中心启动中，端口: " + port);
        
        // 启动服务器
        registryServer.start();
    }
} 