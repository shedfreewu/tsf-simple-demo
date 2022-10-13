## Demo 工程目录

|工程名称|工程说明|
|---|---|
|consumer-demo|微服务治理服务消费者|
|provider-demo|微服务治理服务提供者|

## 依赖说明

pom.xml 中定义了工程需要的依赖包（以下以基于 Spring Cloud Greenwich 版本 SDK 举例说明）：

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.tencent.tsf</groupId>
        <artifactId>spring-cloud-tsf-dependencies</artifactId>
        <version>1.23.14-Greenwich-RELEASE</version>
    </parent>

    <groupId>com.tencent.tsf</groupId>
    <artifactId>tsf-demo</artifactId>
    <version>1.23.14-Greenwich-RELEASE</version>
    <packaging>pom</packaging>

    <modules>
        <module>provider-demo</module>
        <module>consumer-demo</module>
        <module>opensource-zuul-demo</module>
        <module>rocketmq-demo</module>
        <module>mysql-demo</module>
        <module>redis-demo</module>
        <module>mongodb-demo</module>
        <module>kafka-demo</module>
        <module>msgw-demo</module>
        <module>opensource-scg-demo</module>
    </modules>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

```

其中 parent 描述了不同微服务 demo 共同的 TSF 依赖。

```xml
<parent>
        <groupId>com.tencent.tsf</groupId>
        <artifactId>spring-cloud-tsf-dependencies</artifactId>
        <version><!-- 调整为 SDK 最新版本号 --></version>
</parent>
```
