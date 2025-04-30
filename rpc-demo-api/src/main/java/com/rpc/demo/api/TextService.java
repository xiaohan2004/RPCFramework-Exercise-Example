package com.rpc.demo.api;

/**
 * 文本服务接口
 * 模拟 AI 回复功能
 */
public interface TextService {
    /**
     * 获取AI回复
     *
     * @param userInput 用户输入
     * @return AI回复
     */
    String aiReply(String userInput);
} 