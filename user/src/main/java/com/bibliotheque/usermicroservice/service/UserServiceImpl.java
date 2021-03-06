package com.bibliotheque.usermicroservice.service;

import com.bibliotheque.usermicroservice.exceptions.UserCreationException;
import com.bibliotheque.usermicroservice.exceptions.UserNotFoundException;
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
        User user = userRepository.getOne(id);
        if(user == null) throw new UserNotFoundException(" L'utilisateur n'existe pas");
        return user;
    }

    @Override
    public User createUser(UserDTO userDTO) {
        //todo : vérifier que l'email n'existe pas dans bdd ++++ ajouter les nouveaux paramètres.
        if( userDTO.getFirstName() == null ) {
            throw new UserCreationException("Veuillez à renseigner un prénom ");
        }

        if( userDTO.getLastName() == null ) {
            throw new UserCreationException(" Veuillez à renseigner un nom");
        }

        if( userDTO.getBirthday() == null ) {
            throw new UserCreationException(" Veuillez à renseigner une date de naissance");
        }

        if( userDTO.getPhone() == null ) {
            throw new UserCreationException(" Veuillez à renseigner un numéro de téléphone");
        }

        if( userDTO.getEmail() == null ) {
            throw new UserCreationException(" Veuillez à renseigner un email");
        }

        if( userDTO.getAddress() == null ) {
            throw new UserCreationException("Veuillez à renseigner une adresse");
        }

        if( userDTO.getPostalCode() == null ) {
            throw new UserCreationException("Veuillez à renseigner un numéro de code postal");
        }

        if( userDTO.getCity() == null ) {
            throw new UserCreationException(" Veuillez à renseigner une ville");
        }

        User user = userMapper.userDtoToUser(userDTO);
        return userRepository.save(user);
    }

    @Override
    public User getMyProfil(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null) throw new UserNotFoundException(" L'utilisateur n'existe pas");
       // userMapper.userToUserDTO(user);
        return user;
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
