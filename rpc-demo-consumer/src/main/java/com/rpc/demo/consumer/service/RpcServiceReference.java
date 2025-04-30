package com.rpc.demo.consumer.service;

import com.rpc.client.RpcClient;
import com.rpc.client.local.ConditionEvaluator;
import com.rpc.core.annotation.RpcReference;
import com.rpc.demo.api.MatrixService;
import com.rpc.demo.api.TextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * RPC服务引用
 * 用于引入远程服务
 */
@Slf4j
@Component
public class RpcServiceReference {

    @RpcReference(version = "1.0.0", enableLocalService = true, condition = "time0900-1800")
    private MatrixService matrixService;

    @RpcReference(version = "1.0.0", enableLocalService = true, condition = "count3")
    private TextService textService;

    static {
        // 注册自定义条件处理器，处理count开头的条件
        // 格式: count后面跟一个数字N，表示每N次调用使用1次远程服务
        ConditionEvaluator.registerConditionHandler("count", new Predicate<String>() {
            private final AtomicInteger counter = new AtomicInteger(0);

            @Override
            public boolean test(String condition) {
                try {
                    int n = Integer.parseInt(condition.substring(5));
                    int current = counter.incrementAndGet();
                    if (current >= n) {
                        counter.set(0);
                        return true; // 每n次调用返回1次true，使用远程服务
                    }
                    return false;
                } catch (Exception e) {
                    return false;
                }
            }
        });
    }

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