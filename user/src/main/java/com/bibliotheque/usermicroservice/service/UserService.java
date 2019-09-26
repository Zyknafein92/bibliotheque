package com.bibliotheque.usermicroservice.service;

import com.bibliotheque.usermicroservice.model.User;
import com.bibliotheque.usermicroservice.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUser(Long id);

    User createUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(Long id);
}
