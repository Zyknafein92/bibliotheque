package com.bibliotheque.borrowmicroservice.borrow.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
public class Book {

    private Long id;
    private String title;
    private String author;
    private String description;
    private String gender;
    private String picture;
    private Boolean avaible;

    public Book() {
    }
}
