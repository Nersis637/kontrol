package com.lab7.service;

import com.lab7.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseServiceKR<T> {
    List<T> getList();
    T get(int id);
    void create(T tmp);
    void update(T tmp);
    void delete(int id);
}
