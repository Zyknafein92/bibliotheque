package com.bibliotheque.usermicroservice.controller;


import com.bibliotheque.usermicroservice.model.User;
import com.bibliotheque.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/api/user/getAll")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/api/user/getUser")
    public  User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping(value="/api/user/addUser")
    public  User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping(value="/api/user/updateUser")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping(value="/api/user/deleteUser")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
