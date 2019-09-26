package com.bibliotheque.usermicroservice.controller;


import com.bibliotheque.usermicroservice.model.User;
import com.bibliotheque.usermicroservice.service.UserService;
import com.bibliotheque.usermicroservice.service.dto.UserDTO;
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

    @RequestMapping(value = "/api/user/getUser", method = RequestMethod.GET)
    public  User getUser(@RequestParam(name = "id", defaultValue = "")  String id) {
        return userService.getUser(Long.valueOf(id));
    }

    @RequestMapping(value = "/api/user/addUser", method = RequestMethod.POST)
    public  User createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @RequestMapping(value = "/api/user/updateUser", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
    }


    @RequestMapping(value = "/api/user/deleteUser", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam(name = "id", defaultValue = "")  String id) {
        userService.deleteUser(Long.valueOf(id));
    }
}
