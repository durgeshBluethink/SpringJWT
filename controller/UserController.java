package com.security.springSecurity.controller;

import com.security.springSecurity.entitys.User;
import com.security.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@PreAuthorize("hasRole('Admin')")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllusers(){
        return this.userService.getUserList();
    }
@GetMapping("/users/{username}")
    public  User getUserByName(@PathVariable("username") String username){
        return this.userService.getUser(username);

    }

    @PostMapping("/addUser")
    public  User adduser(@RequestBody User user){
        return this.userService.addUser(user);
    }
}
