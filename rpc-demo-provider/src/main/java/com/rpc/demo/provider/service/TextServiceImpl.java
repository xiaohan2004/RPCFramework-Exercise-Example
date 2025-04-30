package com.rpc.demo.provider.service;

import com.rpc.core.annotation.RpcService;
import com.rpc.demo.api.TextService;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 文本服务实现类
 */
@Slf4j
@RpcService(version = "1.0.0")
public class TextServiceImpl implements TextService {
    
    private static final String[] RESPONSES = {
        "【远程AI】经过深度分析，您说的『%s』非常有道理！",
        "【远程AI】这是一个非常有趣的问题：『%s』，让我思考一下……",
        "【远程AI】我刚刚查阅了1000本书，发现您说的『%s』确实值得探讨！",
        "【远程AI】这个问题『%s』引发了我内心的共鸣。",
        "【远程AI】从逻辑和情感两个维度看，『%s』确实很有意思。"
    };

    private final Random random = new Random();

    @Override
    public String aiReply(String userInput) {
        log.info("远程文本服务接收到请求: {}", userInput);
        int index = random.nextInt(RESPONSES.length);
        return String.format(RESPONSES[index], userInput.trim());
    }
} 