package com.mcqueen.mcqueen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.mcqueen.mcqueen.mapper")
@EnableSwagger2
public class McqueenApplication{

	public static void main(String[] args) {
		SpringApplication.run(McqueenApplication.class, args);
	}

}
