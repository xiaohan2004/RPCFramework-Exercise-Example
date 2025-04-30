package com.rpc.demo.consumer.controller;

import com.rpc.demo.consumer.service.LocalTextServiceImpl;
import com.rpc.demo.consumer.service.RpcServiceReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 文本服务控制器
 */
@Slf4j
@RestController
@RequestMapping("/text")
public class TextController {
    
    @Autowired
    private RpcServiceReference rpcServiceReference;
    
    @Autowired
    private LocalTextServiceImpl localTextService;
    
    /**
     * AI回复接口
     */
    @PostMapping("/ai-reply")
    public Map<String, Object> aiReply(@RequestBody Map<String, String> params) {
        String userInput = params.get("input");
        
        Map<String, Object> result = new HashMap<>();
        try {
            // 使用远程服务
            String remoteReply = rpcServiceReference.getTextService().aiReply(userInput);
            result.put("远程回复", remoteReply);
            
            // 使用本地服务
            String localReply = localTextService.aiReply(userInput);
            result.put("本地回复", localReply);
            
            result.put("success", true);
        } catch (Exception e) {
            log.error("AI回复生成错误", e);
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 简单的文本响应接口
     */
    @GetMapping("/ping")
    public Map<String, Object> ping() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "Web服务消费者正常运行中");
        return result;
    }
} 