package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

// 该类必须在所有包的最根目录
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
