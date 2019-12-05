package com.bibliotheque.zuulserver.gateway.services;

import com.bibliotheque.zuulserver.gateway.exceptions.UserCreationException;
import com.bibliotheque.zuulserver.gateway.exceptions.UserNotFoundException;
import com.bibliotheque.zuulserver.gateway.model.Role;
import com.bibliotheque.zuulserver.gateway.model.RoleName;
import com.bibliotheque.zuulserver.gateway.model.User;
import com.bibliotheque.zuulserver.gateway.repository.RoleRepository;
import com.bibliotheque.zuulserver.gateway.repository.UserRepository;
import com.bibliotheque.zuulserver.gateway.services.dto.UserDTO;
import com.bibliotheque.zuulserver.gateway.services.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        User user = userRepository.getOne(id);
        if(user == null) throw new UserNotFoundException(" L'utilisateur n'existe pas");
        return user;
    }

    @Override
    public User createUser(UserDTO userDTO) {

        if( userDTO.getEmail() == null ) {
            throw new UserCreationException("Veuillez à renseigner un Email ");
        }

        if( userDTO.getPassword() == null ) {
            throw new UserCreationException(" Veuillez rajouter un password");
        }

        if( userDTO.getRoles() == null ) {
            Set<Role> roles= new HashSet<>();
            Role roleUser = roleRepository.findByName(RoleName.ROLE_USER);
            roles.add(roleUser);
        }

        User user = userMapper.userDtoToUser(userDTO);
        return userRepository.save(user);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = userRepository.getOne(userDTO.getId());
        if(user == null) throw new UserNotFoundException(" L'utilisateur n'existe pas");
        userMapper.updateUserFromUserDTO(userDTO, user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
