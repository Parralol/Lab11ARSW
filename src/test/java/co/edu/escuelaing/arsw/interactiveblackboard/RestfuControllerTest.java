package co.edu.escuelaing.arsw.interactiveblackboard;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import co.edu.escuelaing.arws.interactiveblackboard.controllers.RestfuController;
import co.edu.escuelaing.arws.interactiveblackboard.redis.TicketRepository;

@WebMvcTest(RestfuController.class)
@SpringBootTest(classes = RestfuController.class)
class RestfuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TicketRepository ticketRepo;

    @InjectMocks
    private RestfuController restfuController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTicket() throws Exception {
        // Arrange
        Integer ticket = 12345;
        when(ticketRepo.getTicket()).thenReturn(ticket);

        // Act & Assert
        mockMvc.perform(get("/getticket"))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"ticket\":\"12345\"}"));
        
        verify(ticketRepo, times(1)).getTicket();  // Verify that getTicket was called once
    }
}
