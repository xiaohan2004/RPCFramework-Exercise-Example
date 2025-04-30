package com.rpc.demo.consumer.controller;

import com.rpc.demo.api.MatrixService;
import com.rpc.demo.consumer.service.LocalMatrixServiceImpl;
import com.rpc.demo.consumer.service.RpcServiceReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 矩阵服务控制器
 */
@Slf4j
@RestController
@RequestMapping("/matrix")
public class MatrixController {
    
    @Autowired
    private RpcServiceReference rpcServiceReference;
    
    @Autowired
    private LocalMatrixServiceImpl localMatrixService;
    
    /**
     * 矩阵加法
     */
    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Map<String, double[][]> params) {
        double[][] a = params.get("a");
        double[][] b = params.get("b");
        
        Map<String, Object> result = new HashMap<>();
        try {
            // 使用远程服务
            double[][] remoteResult = rpcServiceReference.getMatrixService().add(a, b);
            result.put("远程计算结果", deepToString(remoteResult));

            result.put("success", true);
        } catch (Exception e) {
            log.error("矩阵加法计算错误", e);
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 矩阵乘法
     */
    @PostMapping("/multiply")
    public Map<String, Object> multiply(@RequestBody Map<String, double[][]> params) {
        double[][] a = params.get("a");
        double[][] b = params.get("b");
        
        Map<String, Object> result = new HashMap<>();
        try {
            // 使用远程服务
            double[][] remoteResult = rpcServiceReference.getMatrixService().multiply(a, b);
            result.put("远程计算结果", deepToString(remoteResult));

            result.put("success", true);
        } catch (Exception e) {
            log.error("矩阵乘法计算错误", e);
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 矩阵转置
     */
    @PostMapping("/transpose")
    public Map<String, Object> transpose(@RequestBody Map<String, double[][]> params) {
        double[][] matrix = params.get("matrix");
        
        Map<String, Object> result = new HashMap<>();
        try {
            // 使用远程服务
            double[][] remoteResult = rpcServiceReference.getMatrixService().transpose(matrix);
            result.put("远程计算结果", deepToString(remoteResult));

            result.put("success", true);
        } catch (Exception e) {
            log.error("矩阵转置计算错误", e);
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 计算行列式
     */
    @PostMapping("/determinant")
    public Map<String, Object> determinant(@RequestBody Map<String, double[][]> params) {
        double[][] matrix = params.get("matrix");
        
        Map<String, Object> result = new HashMap<>();
        try {
            // 使用远程服务
            double remoteResult = rpcServiceReference.getMatrixService().determinant(matrix);
            result.put("远程计算结果", remoteResult);

            result.put("success", true);
        } catch (Exception e) {
            log.error("行列式计算错误", e);
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 辅助方法：将二维数组转为字符串，便于前端显示
     */
    private String deepToString(double[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (double[] row : matrix) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }
} 