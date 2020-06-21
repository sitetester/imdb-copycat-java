package com.imdb.entity;

import javax.persistence.*;

@Entity
@Table(name = "title_basics")
public class TitleBasics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    String tconst;
    String titleType;
    String primaryTitle;
    String originalTitle;
    String isAdult;
    String startYear;
    String endYear;
    String runtimeMinutes;
    String genres;
}
