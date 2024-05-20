package com.lab7.service;

import com.lab7.entity.User;
import com.lab7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name);
        System.out.println(name);
        System.out.println(user.getId_user());
        if (user == null) {
            System.out.println("gdf");
            throw new UsernameNotFoundException("User not found with username: " + name);
        }
        return new CustomUserDetails(user);
    }
}
