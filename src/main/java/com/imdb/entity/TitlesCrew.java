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


    public Long getId() {
        return id;
    }

    public TitlesCrew setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTconst() {
        return tconst;
    }

    public TitlesCrew setTconst(String tconst) {
        this.tconst = tconst;
        return this;
    }

    public String getDirectors() {
        return directors;
    }

    public TitlesCrew setDirectors(String directors) {
        this.directors = directors;
        return this;
    }

    public String getWriters() {
        return writers;
    }

    public TitlesCrew setWriters(String writers) {
        this.writers = writers;
        return this;
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
