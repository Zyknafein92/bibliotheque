package com.bibliotheque.usermicroservice.service;

import com.bibliotheque.usermicroservice.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUser(Long id);

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
