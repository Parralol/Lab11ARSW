package co.edu.escuelaing.arsw.interactiveblackboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import co.edu.escuelaing.arws.interactiveblackboard.controllers.EjemploController;

@SpringBootTest(classes=EjemploController.class)
@AutoConfigureMockMvc
class InteractiveblackboardApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Add more tests for other endpoints or functionality as needed
}

