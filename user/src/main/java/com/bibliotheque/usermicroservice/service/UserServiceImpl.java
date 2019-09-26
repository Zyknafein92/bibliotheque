package com.bibliotheque.usermicroservice.service;

import com.bibliotheque.usermicroservice.model.User;
import com.bibliotheque.usermicroservice.repository.UserRepository;
import com.bibliotheque.usermicroservice.service.dto.UserDTO;
import com.bibliotheque.usermicroservice.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = userMapper.userDtoToUser(userDTO);
        return userRepository.save(user);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = getUser(userDTO.getId());
        userMapper.updateUserFromUserDTO(userDTO, user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
