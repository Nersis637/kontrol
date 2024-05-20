package com.lab7.service;

import com.lab7.entity.Users;

import com.lab7.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DatabaseServiceUserClass implements DatabaseServiceKR<Users> {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Users> getList() {
        List<Users> listUser = new ArrayList<>();
        for (Users user : usersRepository.findAll())
            if(user.getIs_active()){
                listUser.add(user);
            }
        return listUser;
    }

    @Override
    public Users get(int id) {
        if(usersRepository.findById(id).isPresent())
            return usersRepository.findById(id).get();
        else return null;
    }

    @Override
    public void create(Users tmp) {
        usersRepository.save(tmp);
    }

    @Override
    public void update(Users tmp) {
        tmp.setIs_active(true);
        usersRepository.save(tmp);
    }

    @Override
    public void delete(int id) {
        Users user=get(id);
        user.setIs_active(false);
        usersRepository.save(user);
    }
}
