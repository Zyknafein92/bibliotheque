package com.bibliotheque.bookmicroservice.book.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name= "book", schema="public")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="book_id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="description")
    private String description;

    @Column(name="gender")
    private String gender;

    @Column(name="picture")
    private String picture;

    @Column(name="avaible")
    private Boolean avaible;

    public Book() {
    }
}
