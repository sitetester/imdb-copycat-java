package com.imdb.entity;

import javax.persistence.*;

@Entity
@Table(name = "title_principals")
public class TitlePrincipals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String tconst;
    String titleType;
    String primaryTitle;
    String originalTitle;
    String isAdult;
    String startYear;
}
