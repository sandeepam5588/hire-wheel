package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findByFirstNameIgnoreCase(String name);
    List<User> findByFirstNameOrLastNameIgnoreCase(String firstName, String lastName);
    User findByEmailIgnoreCase(String email);
    User findByMobileNoIgnoreCase(String mobileNo);
}
