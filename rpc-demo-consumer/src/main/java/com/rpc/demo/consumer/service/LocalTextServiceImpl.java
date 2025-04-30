package com.rpc.demo.consumer.service;

import com.rpc.demo.api.TextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 本地文本服务实现类
 */
@Slf4j
@Service
public class LocalTextServiceImpl implements TextService {
    
    private static final String[] RESPONSES = {
        "【本地AI】经过深度分析，您说的『%s』非常有道理！",
        "【本地AI】这是一个非常有趣的问题：『%s』，让我思考一下……",
        "【本地AI】我刚刚查阅了1000本书，发现您说的『%s』确实值得探讨！",
        "【本地AI】这个问题『%s』引发了我内心的共鸣。",
        "【本地AI】从逻辑和情感两个维度看，『%s』确实很有意思。"
    };

    private final Random random = new Random();

    @Override
    public String aiReply(String userInput) {
        log.info("本地文本服务接收到请求: {}", userInput);
        int index = random.nextInt(RESPONSES.length);
        return String.format(RESPONSES[index], userInput.trim());
    }
} 