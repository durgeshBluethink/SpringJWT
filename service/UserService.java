package com.security.springSecurity.service;

import com.security.springSecurity.entitys.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> list = new ArrayList<>();

    public UserService() {
        list.add(new User("durgesh","abc","durgesh@gmail.com", "admin"));
    }

    //getAll user


    public List<User> getUserList() {
        return this.list;
    }
    // get single user
    public User getUser(String userNmae){
        return this.list.stream().filter((user) -> user.getUserName().equals(userNmae)).findAny().orElse(null);
    }
    //add  new user
    public User addUser(User user){
       this.list.add(user);
         return user;
    }
}
