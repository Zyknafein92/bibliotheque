package com.bibliotheque.usermicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name= "user", schema="public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="user_id")
    private Long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="birthday")
    private Date birthday;

    @Column(name="phone")
    private String phone;

    // todo : ajouter unique
    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="postalCode")
    private String postalCode;

    @Column(name="city")
    private String city;

    public User() { }


}
