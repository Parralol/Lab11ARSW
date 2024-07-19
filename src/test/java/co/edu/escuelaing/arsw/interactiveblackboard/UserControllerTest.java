package co.edu.escuelaing.arsw.interactiveblackboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import co.edu.escuelaing.arws.interactiveblackboard.controllers.UserController;
import co.edu.escuelaing.arws.interactiveblackboard.entity.User;
import co.edu.escuelaing.arws.interactiveblackboard.service.UserService;

import java.util.Arrays;
import java.util.List;

class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        // Arrange
        User user = new User("username", "encodedPassword");
        when(userService.save(user)).thenReturn(user);

        // Act
        User result = userController.createUser(user);

        // Assert
        assertNotNull(result);
        assertEquals(user.getName(), result.getName());
        assertEquals(user.getPass(), result.getPass());
        verify(userService, times(1)).save(user);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        List<User> users = Arrays.asList(user1, user2);
        when(userService.findAll()).thenReturn(users);

        // Act
        List<User> result = userController.getAllUsers();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(user1));
        assertTrue(result.contains(user2));
        verify(userService, times(1)).findAll();
    }

    @Test
    void testCreates() {
        // Arrange
        String username = "newUser";
        String password = "password";
        String encodedPassword = "encodedPassword";
        User user = new User(username, encodedPassword);

        // Mock the password encoder
        when(passwordEncoder.encode(password)).thenReturn(encodedPassword);

        // Mock the save operation
        when(userService.save(any(User.class))).thenReturn(user);

        // Mock Model
        Model model = mock(Model.class);

        // Act
        String viewName = userController.creates(username, password, model);

        // Assert
        assertEquals("home", viewName);
    }
}
