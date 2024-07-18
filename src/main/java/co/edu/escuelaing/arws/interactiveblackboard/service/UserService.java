package co.edu.escuelaing.arws.interactiveblackboard.service;


import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.escuelaing.arws.interactiveblackboard.entity.User;

public interface UserService extends MongoRepository<User, String>{
    public User findByName(String name);
}
