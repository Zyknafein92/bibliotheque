package com.bibliotheque.borrowmicroservice.borrow.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class BorrowDTO {

    private Long id;
    private String userID;
    private String bookID;
    private Date dateStart;
    private Date dateEnd;
    private Date dateExtend;
    private Boolean isExtend;

}
