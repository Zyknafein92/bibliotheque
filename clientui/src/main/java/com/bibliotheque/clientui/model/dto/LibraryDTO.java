package com.bibliotheque.clientui.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class LibraryDTO {

    private Long id;
    private String name;
    private String adress;
    private String postalCode;
    private String phone;

}
