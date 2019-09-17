package com.bibliotheque.bookmicroservice.book.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private String description;
    private String gender;
    private String picture;
    private Boolean avaible;

}
