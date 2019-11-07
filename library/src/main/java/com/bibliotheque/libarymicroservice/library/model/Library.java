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

    @Column(name ="adress")
    private String adress;

    @Column(name ="postalCode")
    private String postalCode;

    @Column(name ="phone")
    private String phone;

    public Library() {
    }

    public Library(String name, String adress, String postalCode, String phone) {
        this.name = name;
        this.adress = adress;
        this.postalCode = postalCode;
        this.phone = phone;
    }

}
