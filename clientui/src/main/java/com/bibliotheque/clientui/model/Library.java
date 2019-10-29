package com.bibliotheque.clientui.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class Library {

    private Long id;
    private String name;
    private String adress;
    private String postalCode;
    private String phone;

}
