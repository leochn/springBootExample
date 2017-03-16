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
