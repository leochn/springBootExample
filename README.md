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

## springboot 整合mybatis



## springboot 整合redis单机版



## springboot 整合redis集群



