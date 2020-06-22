package com.imdb.entity;

import javax.persistence.*;

@Entity
@Table(name = "title_principals")
public class TitlePrincipals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String tconst;
    String ordering;
    String nconst;
    String category;
    String job;
    String characters;

    protected TitlePrincipals() {
    }

    public TitlePrincipals(String tconst, String ordering, String nconst, String category, String job, String characters) {
        this.tconst = tconst;
        this.ordering = ordering;
        this.nconst = nconst;
        this.category = category;
        this.job = job;
        this.characters = characters;
    }

    public Long getId() {
        return id;
    }

    public TitlePrincipals setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTconst() {
        return tconst;
    }

    public TitlePrincipals setTconst(String tconst) {
        this.tconst = tconst;
        return this;
    }

    public String getOrdering() {
        return ordering;
    }

    public TitlePrincipals setOrdering(String ordering) {
        this.ordering = ordering;
        return this;
    }

    public String getNconst() {
        return nconst;
    }

    public TitlePrincipals setNconst(String nconst) {
        this.nconst = nconst;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public TitlePrincipals setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getJob() {
        return job;
    }

    public TitlePrincipals setJob(String job) {
        this.job = job;
        return this;
    }

    public String getCharacters() {
        return characters;
    }

    public TitlePrincipals setCharacters(String characters) {
        this.characters = characters;
        return this;
    }

    @Override
    public String toString() {
        return "TitlePrincipals{" +
                "id=" + id +
                ", tconst='" + tconst + '\'' +
                ", ordering='" + ordering + '\'' +
                ", nconst='" + nconst + '\'' +
                ", category='" + category + '\'' +
                ", job='" + job + '\'' +
                ", characters='" + characters + '\'' +
                '}';
    }
}
