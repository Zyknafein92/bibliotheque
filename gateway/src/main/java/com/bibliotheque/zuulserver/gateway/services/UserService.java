package com.bibliotheque.zuulserver.gateway.services;

import com.bibliotheque.zuulserver.gateway.model.User;
import com.bibliotheque.zuulserver.gateway.services.dto.UserDTO;

public interface UserService {

    User getUser(Long id);

    User createUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(Long id);
}
