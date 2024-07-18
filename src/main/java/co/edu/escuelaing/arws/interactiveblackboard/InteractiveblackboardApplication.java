package co.edu.escuelaing.arws.interactiveblackboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;

import co.edu.escuelaing.arws.interactiveblackboard.configurator.SpringConfigurator;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

@SpringBootApplication
public class InteractiveblackboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(InteractiveblackboardApplication.class, args);
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				SpringConfigurator.setApplicationContext(servletContext);
			}
		};
	}
}
