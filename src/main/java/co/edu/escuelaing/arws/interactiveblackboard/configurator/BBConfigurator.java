package co.edu.escuelaing.arws.interactiveblackboard.configurator;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import co.edu.escuelaing.arws.interactiveblackboard.annotations.GeneratedExcludeFromCodeCoverage;

@GeneratedExcludeFromCodeCoverage
@Configuration
@EnableWebMvc
public class BBConfigurator implements WebMvcConfigurer {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
