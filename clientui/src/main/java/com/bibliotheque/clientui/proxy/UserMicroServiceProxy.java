package com.bibliotheque.clientui.proxy;

import com.bibliotheque.clientui.model.User;
import com.bibliotheque.clientui.model.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "com.bibliotheque.usermicroservice", url = "localhost:9040")
public interface UserMicroServiceProxy {

    @GetMapping(value = "/api/user/getAll")
    public List<User> getUsers();

    @RequestMapping(value = "/api/user/getUser", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@RequestParam(name = "id", defaultValue = "")  String id);

    @RequestMapping(value = "/api/user/addUser", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO);

    @RequestMapping(value = "/api/user/updateUser", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@RequestBody UserDTO userDTO);

    @RequestMapping(value = "/api/user/deleteUser", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@RequestParam(name = "id", defaultValue = "")  String id);

}
