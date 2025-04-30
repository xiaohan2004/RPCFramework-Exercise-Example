package com.rpc.demo.api;

/**
 * 矩阵运算服务接口
 */
public interface MatrixService {
    /**
     * 矩阵加法
     *
     * @param a 矩阵 A
     * @param b 矩阵 B
     * @return 结果矩阵
     */
    double[][] add(double[][] a, double[][] b);
    
    /**
     * 矩阵乘法
     *
     * @param a 矩阵 A
     * @param b 矩阵 B
     * @return 结果矩阵
     */
    double[][] multiply(double[][] a, double[][] b);
    
    /**
     * 计算矩阵的行列式
     *
     * @param matrix 输入矩阵
     * @return 行列式的值
     */
    double determinant(double[][] matrix);
    
    /**
     * 矩阵转置
     *
     * @param matrix 输入矩阵
     * @return 转置后的矩阵
     */
    double[][] transpose(double[][] matrix);
} 