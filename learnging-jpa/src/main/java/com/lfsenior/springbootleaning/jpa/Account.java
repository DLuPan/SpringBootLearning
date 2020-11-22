package com.lfsenior.springbootleaning.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String pwd;

}
