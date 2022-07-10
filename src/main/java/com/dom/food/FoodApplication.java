package com.dom.food;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dom.food.*.mapper")
@SpringBootApplication
public class FoodApplication {
	// private static String secret;

	// @Value("${jwt.secret}")
	// public void setSecret(String secret) {
	// FoodApplication.secret = secret;
	// }

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
		// System.out.println("===========================>" + secret );
	}

}
