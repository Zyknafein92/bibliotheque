package com.bibliotheque.libarymicroservice.library.service.dto;

import com.bibliotheque.libarymicroservice.library.model.Book;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Data
@Getter
@Setter
public class LibraryDTO {

    private Long id;
    private List<Book> bookList;
    private String name;
    private String adress;
    private String postalCode;
    private String phone;

}
