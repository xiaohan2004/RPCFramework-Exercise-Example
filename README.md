# RPC框架演示项目

这是一个用于演示RPC框架功能的示例项目，包含三个核心组件：注册中心、服务提供者和Web服务消费者。

## 项目结构

项目采用Maven多模块结构：

- **rpc-demo-api**: 共享的API接口定义模块
- **rpc-demo-registry**: 注册中心服务模块
- **rpc-demo-provider**: 服务提供者模块
- **rpc-demo-consumer**: Web服务消费者模块

## 功能特点

本示例展示了以下功能：

1. **矩阵运算服务**：包括矩阵加法、乘法、转置和行列式计算
2. **AI文本服务**：模拟AI回复功能
3. **双重实现**：同时提供本地和远程服务实现，便于对比
4. **Web界面**：直观的Web界面展示RPC调用过程

## 使用指南

### 1. 编译项目

```bash
mvn clean package
```

### 2. 启动注册中心

```bash
java -jar rpc-demo-registry/target/rpc-demo-registry-1.0-SNAPSHOT.jar
```

注册中心默认在8000端口启动。

### 3. 启动服务提供者

```bash
java -jar rpc-demo-provider/target/rpc-demo-provider-1.0-SNAPSHOT.jar
```

服务提供者默认在9000端口启动。

### 4. 启动Web服务消费者

```bash
java -jar rpc-demo-consumer/target/rpc-demo-consumer-1.0-SNAPSHOT.jar
```

Web服务默认在8080端口启动。

### 5. 访问Web界面

打开浏览器，访问 http://localhost:8080 进入演示系统。

## 配置说明

各组件的配置文件位于各自模块的resources目录下：

- 注册中心：无需特别配置
- 服务提供者：`rpc.properties`
- Web服务消费者：`rpc.properties` 和 `application.yml`

## 运行环境要求

- JDK 17 或更高版本
- Maven 3.6 或更高版本
- 支持现代浏览器（Chrome、Firefox、Edge等） 