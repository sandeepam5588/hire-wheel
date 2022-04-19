package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.User;

public interface UserService {
     User getUser(User user);
     User gerUserDetailByEmail(String enail);
     User createUser(User user);
}
