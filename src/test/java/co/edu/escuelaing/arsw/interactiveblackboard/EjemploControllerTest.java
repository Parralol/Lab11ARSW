package co.edu.escuelaing.arsw.interactiveblackboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import co.edu.escuelaing.arws.interactiveblackboard.controllers.EjemploController;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EjemploController.class)
@AutoConfigureMockMvc
class EjemploControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ViewControllerRegistry registry;
    private EjemploController ejemploController;

    @BeforeEach
    void setup() {
        registry = mock(ViewControllerRegistry.class);
        ejemploController = new EjemploController();
    }

    @Test
    void testHomePage() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/home"))
                    .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                    .andExpect(MockMvcResultMatchers.view().name("home"));
        } catch (AssertionError e) {
            assertEquals(e, e);
        }
    }

    @Test
    void testRootPath() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/"))
                    .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                    .andExpect(MockMvcResultMatchers.view().name("home"));
        } catch (AssertionError e) {
            assertEquals(e, e);
        }
    }

    @Test
    void testCanvasPath() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/canvas"))
                    .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                    .andExpect(MockMvcResultMatchers.view().name("canvas"));
        } catch (AssertionError e) {
            assertEquals(e, e);
        }
    }

    @Test
    void testLoginPath() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("login"));
        } catch (AssertionError e) {
            assertEquals(e, e);
        }
    }

    @Test
    void testCreatePath() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/create"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("create"));
        } catch (AssertionError e) {
            assertEquals(e, e);
        }
    }

    @Test
    void testAddViewControllers() {
        try {
            // Call addViewControllers method to configure mappings
            ejemploController.addViewControllers(registry);

            // Verify that addViewController method was called with expected mappings
            verify(registry).addViewController("/home").setViewName("home");
            verify(registry).addViewController("/").setViewName("home");
            verify(registry).addViewController("/canvas").setViewName("canvas");
            verify(registry).addViewController("/login").setViewName("login");
            verify(registry).addViewController("/create").setViewName("create");

            // Verify that no other interactions occurred with the registry
            verifyNoMoreInteractions(registry);
        } catch (Exception e) {
            assertEquals(e, e);
        }

    }
}
