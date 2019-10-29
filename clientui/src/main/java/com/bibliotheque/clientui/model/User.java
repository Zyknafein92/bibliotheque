package com.bibliotheque.clientui.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String adress;
    private String postalCode;

}
