package co.edu.escuelaing.arws.interactiveblackboard.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import co.edu.escuelaing.arws.interactiveblackboard.entity.User;
import co.edu.escuelaing.arws.interactiveblackboard.model.MyUserPrincipal;
import co.edu.escuelaing.arws.interactiveblackboard.service.UserService;

@Service
public class DrawingServiceController implements UserDetailsService {

    @Autowired
    private UserService userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> xd = new ArrayList<>();
        xd.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new MyUserPrincipal(user, new HashSet<>(xd));
    }
}
