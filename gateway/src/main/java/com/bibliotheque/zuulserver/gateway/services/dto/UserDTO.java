package com.bibliotheque.zuulserver.gateway.services.dto;


import com.bibliotheque.zuulserver.gateway.model.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class UserDTO {

    private Long id;

    private String email;

    private String password;

    private Set<Role> roles;
}
