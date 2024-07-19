package co.edu.escuelaing.arsw.interactiveblackboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.edu.escuelaing.arws.interactiveblackboard.controllers.DrawingServiceController;
import co.edu.escuelaing.arws.interactiveblackboard.entity.User;
import co.edu.escuelaing.arws.interactiveblackboard.service.UserService;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DrawingServiceControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private DrawingServiceController drawingServiceController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoadUserByUsername_Success() {
        // Arrange
        User user = new User("username", "password");
        when(userService.findByName("username")).thenReturn(user);

        // Act
        UserDetails userDetails = drawingServiceController.loadUserByUsername("username");

        // Assert
        assertNotNull(userDetails);
        assertEquals("username", userDetails.getUsername());
        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        // Arrange
        when(userService.findByName("nonexistent")).thenReturn(null);

        // Act & Assert
        assertThrows(UsernameNotFoundException.class, () -> {
            drawingServiceController.loadUserByUsername("nonexistent");
        });
    }
}
