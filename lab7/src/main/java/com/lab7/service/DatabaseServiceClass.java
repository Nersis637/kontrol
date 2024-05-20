package com.lab7.service;

import com.lab7.entity.User;

import com.lab7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseServiceClass implements DatabaseService{


    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getListUser() {
        return userRepository.findAll();
    }

    @Override
    public void registration(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
