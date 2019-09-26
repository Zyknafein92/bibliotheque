package com.bibliotheque.usermicroservice.service.mapper;

import com.bibliotheque.usermicroservice.model.User;
import com.bibliotheque.usermicroservice.service.dto.UserDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    User userDtoToUser(UserDTO userDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updateUserFromUserDTO(UserDTO userDTO, @MappingTarget User user);

}
