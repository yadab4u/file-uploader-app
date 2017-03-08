package com.upload.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.upload.*" })
@EntityScan("com.upload.*") 
@EnableCaching
@EnableJpaRepositories
public class FileUploaderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploaderAppApplication.class, args);
	}
	
}
