package com.bibliotheque.usermicroservice.controller;


import com.bibliotheque.usermicroservice.model.User;
import com.bibliotheque.usermicroservice.service.UserService;
import com.bibliotheque.usermicroservice.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/api/user/getAll")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/user/getUser", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@RequestParam(name = "id", defaultValue = "")  String id) {
        User user = userService.getUser(Long.valueOf(id));
        if(user == null) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/api/user/addUser", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
        User user = userService.createUser(userDTO);
        if(user == null) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(user, HttpStatus.CREATED) ;
    }

    @RequestMapping(value = "/api/user/updateUser", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/api/user/deleteUser", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@RequestParam(name = "id", defaultValue = "")  String id) {
        User user = userService.getUser(Long.valueOf(id));
        if(user == null) return ResponseEntity.noContent().build();
        userService.deleteUser(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
