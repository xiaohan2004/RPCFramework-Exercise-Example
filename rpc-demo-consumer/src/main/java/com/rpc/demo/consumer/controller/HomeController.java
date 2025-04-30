package com.rpc.demo.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 */
@Controller
@RequestMapping("/")
public class HomeController {
    
    /**
     * 首页
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    /**
     * 矩阵操作页面
     */
    @GetMapping("/matrix-demo")
    public String matrixDemo() {
        return "matrix-demo";
    }
    
    /**
     * AI文本服务页面
     */
    @GetMapping("/text-demo")
    public String textDemo() {
        return "text-demo";
    }
} 