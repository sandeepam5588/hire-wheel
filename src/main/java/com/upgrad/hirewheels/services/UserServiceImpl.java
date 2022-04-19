package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.UserDao;
import com.upgrad.hirewheels.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    /**
     * Checks if the user is registered or not.
     * If registered it returns the user details else throws an error.
     * @param user
     * @return
     */
    @Override
    public User getUser(User user) {
        User returnedUser = userDao.findByEmailIgnoreCase(user.getEmail());
        if (returnedUser == null){
            System.out.println("User not registered");
            return returnedUser;
        }else {
            returnedUser = userDao.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if (returnedUser == null){
                System.out.println("Invalid Credentials");
                return returnedUser;
            }
        }
        return returnedUser;
    }

    /**
     * Checks if the user is already exists or not by fetching the email-id
     * If exists returns the user else null
     * @param email
     * @return
     */
    @Override
    public User gerUserDetailByEmail(String email) {
        User retrievedUser = userDao.findByEmailIgnoreCase(email);
        if (retrievedUser == null){
            System.out.println("User not Registered");
        }
        return retrievedUser;
    }

    /**
     * Checks if the user mobile number/email is already exists or not.
     * If not exists, saves the user details else throws an error.
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
        User checkUser = userDao.findByEmailIgnoreCase(user.getEmail());
        if (checkUser != null){
            System.out.println("Email already exists");
            return checkUser;
        }
        checkUser = userDao.findByMobileNoIgnoreCase(user.getMobileNo());
        if (checkUser != null){
            System.out.println("Mobile number already exists");
        }
        User savedUser = userDao.save(user);
        return savedUser;
    }
}
