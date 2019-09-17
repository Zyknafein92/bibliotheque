package com.bibliotheque.borrowmicroservice.borrow.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name= "borrow", schema="public")
public class Borrow {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="borrow_id")
    private Long id;

    @Column(name="user_id")
    private User user;

    @Column(name="book_id")
    private Book book;

    @Column(name="date_start_borrow")
    private Date dateStart;

    @Column(name="date_end")
    private Date dateEnd;

    @Column(name="date_extend")
    private Date dateExtend;

    @Column(name="is_extend")
    private Boolean isExtend;
}
