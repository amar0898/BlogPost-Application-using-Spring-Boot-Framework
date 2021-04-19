package com.upgrad.BloggingApp.service;

import com.upgrad.BloggingApp.model.User;
import com.upgrad.BloggingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(User user) {
        User existingUser = userRepository.checkCredentials(user.getUsername(),user.getPassword());
        if(existingUser == null){
           return null;
        }

        else{
            return existingUser;
        }
    }

    public void registerUser(User newUser){

        userRepository.registerUser(newUser);

    }
}
