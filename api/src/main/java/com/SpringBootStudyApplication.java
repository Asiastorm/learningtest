package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.huawei")
@SpringBootApplication
public class SpringBootStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudyApplication.class, args);
	}

}
