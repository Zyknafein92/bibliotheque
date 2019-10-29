package com.bibliotheque.clientui.model;


import lombok.Data;


import java.util.Date;

@Data
public class Borrow {

    private Long id;
    private String userID;
    private String bookID;
    private Date dateStart;
    private Date dateEnd;
    private Date dateExtend;
    private Boolean isExtend;

}
