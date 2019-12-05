package com.bibliotheque.zuulserver.gateway.services.mapper;

import com.bibliotheque.zuulserver.gateway.model.User;
import com.bibliotheque.zuulserver.gateway.services.dto.UserDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    UserDTO userToUserDTO(User user);

    User userDtoToUser(UserDTO userDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updateUserFromUserDTO(UserDTO userDTO, @MappingTarget User user);
}
