package com.lab7.service;


import com.lab7.entity.User;

import java.util.List;

public interface DatabaseService {

    List<User> getListUser();

    void registration(User user);
}
