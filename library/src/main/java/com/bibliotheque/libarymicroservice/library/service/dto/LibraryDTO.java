package com.bibliotheque.libarymicroservice.library.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

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
