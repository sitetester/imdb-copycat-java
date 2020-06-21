package com.imdb.entity;

import javax.persistence.*;

@Entity
@Table(name = "titles_crew")
public class TitlesCrew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String tconst;
    String directors;
    String writers;

    protected TitlesCrew() {
    }

    public TitlesCrew(String tconst, String directors, String writers) {

        this.tconst = tconst;
        this.directors = directors;
        this.writers = writers;
    }
}
