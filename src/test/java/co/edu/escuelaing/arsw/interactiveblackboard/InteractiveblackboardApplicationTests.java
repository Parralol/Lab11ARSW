package co.edu.escuelaing.arsw.interactiveblackboard;

import co.edu.escuelaing.arws.interactiveblackboard.configurator.SpringConfigurator;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration
class InteractiveblackboardApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;
/** 
    @Test
    void contextLoads() {
        assertNotNull(applicationContext);
    }

    @Test
    void servletContextInitializerTest() throws ServletException {
        // Simulate ServletContext initialization
        ServletContext servletContext = new MockServletContext();
        SpringConfigurator configurator = new SpringConfigurator();
        configurator.setApplicationContext(servletContext);
        // assertNotNull(configurator.getApplicationContext());
    }


    MockServletContext class for testing purposes
    private static class MockServletContext implements ServletContext {
        @Override
        public String getContextPath() {
            return null;
        }
        // Override other methods as needed for testing
    }
    */
}