package com.rpc.demo.provider.service;

import com.rpc.core.annotation.RpcService;
import com.rpc.demo.api.MatrixService;
import lombok.extern.slf4j.Slf4j;

/**
 * 矩阵运算服务实现类
 */
@Slf4j
@RpcService(version = "1.0.0")
public class MatrixServiceImpl implements MatrixService {

    @Override
    public double[][] add(double[][] a, double[][] b) {
        log.info("执行远程矩阵加法计算");
        int rows = a.length;
        int cols = a[0].length;
        
        if (rows != b.length || cols != b[0].length) {
            throw new IllegalArgumentException("矩阵维度不匹配，无法相加");
        }
        
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        
        return result;
    }

    @Override
    public double[][] multiply(double[][] a, double[][] b) {
        log.info("执行远程矩阵乘法计算");
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;
        
        if (colsA != rowsB) {
            throw new IllegalArgumentException("矩阵维度不匹配，无法相乘");
        }
        
        double[][] result = new double[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        
        return result;
    }

    @Override
    public double determinant(double[][] matrix) {
        log.info("执行远程矩阵行列式计算");
        int n = matrix.length;
        
        if (n != matrix[0].length) {
            throw new IllegalArgumentException("只能计算方阵的行列式");
        }
        
        if (n == 1) {
            return matrix[0][0];
        }
        
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        
        double det = 0;
        for (int i = 0; i < n; i++) {
            double[][] minor = new double[n-1][n-1];
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k < i) {
                        minor[j-1][k] = matrix[j][k];
                    } else if (k > i) {
                        minor[j-1][k-1] = matrix[j][k];
                    }
                }
            }
            det += Math.pow(-1, i) * matrix[0][i] * determinant(minor);
        }
        
        return det;
    }

    @Override
    public double[][] transpose(double[][] matrix) {
        log.info("执行远程矩阵转置计算");
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        double[][] result = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        
        return result;
    }
} 