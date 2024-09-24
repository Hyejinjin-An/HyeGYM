package com.hyegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class HyeGymApplication extends SpringBootServletInitializer{
	
	//exclude={DataSourceAutoConfiguration.class} <- db 연결하면 삭제
	public static void main(String[] args) {
		SpringApplication.run(HyeGymApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HyeGymApplication.class);
	}


}
