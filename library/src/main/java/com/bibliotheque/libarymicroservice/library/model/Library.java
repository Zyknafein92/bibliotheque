package com.bibliotheque.libarymicroservice.library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name= "library", schema="public")
public class Library {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="user_id")
    private Long id;

    //todo : mapping
    private List<Book> bookList;

    @Column(name ="name")
    private String name;

    @Column(name ="adress")
    private String adress;

    @Column(name ="postalCode")
    private String postalCode;

    @Column(name ="phone")
    private String phone;

}
