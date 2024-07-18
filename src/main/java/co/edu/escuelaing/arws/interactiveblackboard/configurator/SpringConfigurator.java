package co.edu.escuelaing.arws.interactiveblackboard.configurator;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jakarta.servlet.ServletContext;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;

public class SpringConfigurator extends ServerEndpointConfig.Configurator {

    private static volatile WebApplicationContext context;

    public static void setApplicationContext(ServletContext servletContext) {
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }

    @Override
    public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
        return context.getAutowireCapableBeanFactory().createBean(endpointClass);
    }

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        super.modifyHandshake(sec, request, response);
    }
}
