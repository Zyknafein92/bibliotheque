package com.bibliotheque.libarymicroservice.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name= "library", schema="public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Library {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="library_id")
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="address")
    private String address;

    @Column(name ="phone")
    private String phone;

    public Library() {
    }

    public Library(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

}
