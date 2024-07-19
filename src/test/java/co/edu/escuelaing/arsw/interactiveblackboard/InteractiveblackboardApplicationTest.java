package co.edu.escuelaing.arsw.interactiveblackboard;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import co.edu.escuelaing.arws.interactiveblackboard.InteractiveblackboardApplication;

class InteractiveblackboardApplicationTest {

    @Mock
    private ServletContext servletContext;

    @InjectMocks
    private InteractiveblackboardApplication application;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void contextLoads() {
        // This test will pass if the application context loads successfully
    }

    @Test
    void testServletContextInitializer() throws ServletException {
        // Arrange
        ServletContextInitializer initializer = application.servletContextInitializer();
    }
}
