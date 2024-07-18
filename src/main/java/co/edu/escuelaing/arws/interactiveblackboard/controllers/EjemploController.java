package co.edu.escuelaing.arws.interactiveblackboard.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EjemploController implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/canvas").setViewName("canvas");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/create").setViewName("create");
	}


}