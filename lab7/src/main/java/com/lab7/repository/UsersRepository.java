package com.lab7.repository;

import com.lab7.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository  extends JpaRepository<Users, Integer> {
}
