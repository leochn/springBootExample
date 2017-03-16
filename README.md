# springBootExample

约定大于配置


## springboot 基础
创建maven工程,添加基本的依赖
```
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.3.RELEASE</version>
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

添加入口：
```
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 该类必须在所有包的最根目录
@SpringBootApplication
public class ExampleApplication {
    // 项目入口
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}

```

添加控制器:
```
// 直接支持RESTFul
@RestController  
public class Example {
    @Autowired
    private UserService userService;
    
    @RequestMapping("/hello")  
    public String home() {  
        return "Hello World!";  
    }  
    @RequestMapping("/hello/{myName}")  
    public String index(@PathVariable String myName) {  
        return "Hello "+myName+"!";  
    }  
}
```

## springboot 修改端口

有时候我们可能需要启动不止一个SpringBoot，而SpringBoot默认的端口号是8080，所以这时候我们就需要修改SpringBoot的默认端口了。修改SpringBoot的默认端口有两种方式。下面就分别说一下这两种方式。

* 修改application.properties

第一种方式我们只需要在application.properties中加这样的一句话就可以了 ```server.port=8089``` 为什么这种方式可以实现修改SpringBoot的默认端口呢？因为在SpringBoot中有这样的一个类：ServerProperties。我们可以大致看一下这个类：
```java
@ConfigurationProperties(prefix = "server", ignoreUnknownFields = true)
public class ServerProperties
    implements EmbeddedServletContainerCustomizer, EnvironmentAware, Ordered {

    /**
     * Server HTTP port.
     */
    private Integer port;

    /**
     * Network address to which the server should bind to.
     */
    private InetAddress address;
    // ................
}
```

在这个类里有一个@ConfigurationProperties注解，这个注解会读取SpringBoot的默认配置文件application.properties的值注入到bean里。这里定义了一个server的前缀和一个port字段，所以在SpringBoot启动的时候会从application.properties读取到server.port的值。我们接着往下看一下：


* 实现EmbeddedServletContainerCustomizer

我们在上面看到了端口号是在customize这个方法中设置的，而这个方法是在EmbeddedServletContainerCustomizer这个接口中的，所以我们可以实现这个接口，来更改SpringBoot的默认端口号。具体代码如下：
```java
@SpringBootApplication
public class ExampleApplication implements EmbeddedServletContainerCustomizer{
    // 项目入口
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
    @Override  
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {  
        //#修改springboot中web启动的端口,方法2:
        //ExampleApplication实现EmbeddedServletContainerCustomizer接口.
        configurableEmbeddedServletContainer.setPort(8089);  
    } 
}
```

## springboot 整合mybatis

* application.properties配置文件:
``` 
# 整合mybatis
mybatis.mapper-locations=classpath:mapper/*Mapper.xml
mybatis.config-location=classpath:mapper/config/sqlMapConfig.xml

spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/tusers?characterEncoding=utf-8
spring.datasource.username=root
spring.datasource.password=root
```
* pom.xml 添加信息:
```
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.2.0</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```


## springboot 整合redis单机版



## springboot 整合redis集群



