package com.mirit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);
//		Ground ground = context.getBean(Ground.class);
//		System.out.println("Ground: "+ ground.name);
	}

}
