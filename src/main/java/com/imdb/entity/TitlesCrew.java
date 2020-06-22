package com.imdb.entity;

import javax.persistence.*;

@Entity
@Table(name = "titles_crew")
public class TitlesCrew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String tconst;

    @Column(columnDefinition = "TEXT")
    String directors;

    @Column(columnDefinition = "TEXT")
    String writers;

    protected TitlesCrew() {
    }

    public TitlesCrew(String tconst, String directors, String writers) {

        this.tconst = tconst;
        this.directors = directors;
        this.writers = writers;
    }


    @Override
    public String toString() {
        return "TitlesCrew{" +
                "id=" + id +
                ", tconst='" + tconst + '\'' +
                ", directors='" + directors + '\'' +
                ", writers='" + writers + '\'' +
                '}';
    }
}
