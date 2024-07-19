package co.edu.escuelaing.arws.interactiveblackboard.configurator;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.edu.escuelaing.arws.interactiveblackboard.annotations.GeneratedExcludeFromCodeCoverage;
import jakarta.servlet.ServletContext;
import jakarta.websocket.server.ServerEndpointConfig;

@GeneratedExcludeFromCodeCoverage
public class SpringConfigurator extends ServerEndpointConfig.Configurator {

    private static volatile WebApplicationContext context;

    public static void setApplicationContext(ServletContext servletContext) {
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }

    @Override
    public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
        return context.getAutowireCapableBeanFactory().createBean(endpointClass);
    }

}
