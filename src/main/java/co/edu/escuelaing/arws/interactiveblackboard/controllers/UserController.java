package co.edu.escuelaing.arws.interactiveblackboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import co.edu.escuelaing.arws.interactiveblackboard.entity.User;

import co.edu.escuelaing.arws.interactiveblackboard.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class UserController {

    private final UserService userService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User createUser(User customer) {
        return userService.save(customer);
    }

    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/creates")
    public String creates(String usern, String password, Model model) {

        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(usern, encodedPassword);

        createUser(user);
        System.out.println("Successfully created" + usern + " USER WITH " + encodedPassword + "PASSWORD");

        return "home";
    }

}
