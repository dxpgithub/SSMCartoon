package com.city;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*	@SpringBootApplication相当于：
@SpringBootConfiguration 实现配置文件功能
@EnableAutoConfiguration 打开自动配置功能
@CompoentScan 组件扫描功能
*/
@SpringBootApplication
@MapperScan(basePackages="com.city.cartoon.mapper")
public class RunApp {
	
	public static void main(String[] args) {
	
			SpringApplication.run(RunApp.class, args);
		

	}

}
