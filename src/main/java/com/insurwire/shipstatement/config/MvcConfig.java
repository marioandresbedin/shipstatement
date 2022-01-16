package com.insurwire.shipstatement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("admin/dashboard/index");
		registry.addViewController("/").setViewName("admin/dashboard/index");
		registry.addViewController("/hello").setViewName("admin/dashboard/index");
		registry.addViewController("/login").setViewName("admin/auth/login");
	}

}