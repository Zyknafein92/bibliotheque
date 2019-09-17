package com.bibliotheque.usermicroservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name= "user", schema="public")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="user_id")
    private Long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="adress")
    private String adress;

    @Column(name="postalCode")
    private String postalCode;
}
