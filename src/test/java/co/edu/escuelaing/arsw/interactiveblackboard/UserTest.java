package co.edu.escuelaing.arsw.interactiveblackboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import co.edu.escuelaing.arws.interactiveblackboard.entity.User;

public class UserTest {

    @Test
    void testDefaultConstructor() {
        User user = new User();
        assertNotNull(user);
        assertNull(user.getName());
        assertNull(user.getPass());
    }

    @Test
    void testParameterizedConstructor() {
        User user = new User("john_doe", "password123");
        assertNotNull(user);
        assertEquals("john_doe", user.getName());
        assertEquals("password123", user.getPass());
    }

    @Test
    void testGettersAndSetters() {
        User user = new User();
        user.setName("john_doe");
        user.setPass("password123");

        assertEquals("john_doe", user.getName());
        assertEquals("password123", user.getPass());
    }

    @Test
    void testToString() {
        User user = new User("john_doe", "password123");
        String expectedString = "User [name=john_doe, pass=password123]";
        assertEquals(expectedString, user.toString());
    }
}