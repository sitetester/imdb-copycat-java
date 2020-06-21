package com.imdb.entity;

import javax.persistence.*;

@Entity
@Table(name = "name_basics")

public class NameBasics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // The other properties are left unannotated. It is assumed that they are mapped to columns that share the same names as the properties themselves.
    String nconst;
    String primaryName;
    String birthYear;
    String deathYear;
    String primaryProfession;
    String knownForTitles;

    // https://spring.io/guides/gs/accessing-data-jpa/
    // The default constructor exists only for the sake of JPA. You do not use it directly, so it is designated as protected.
    // The other constructor is the one you use to create instances of NameBasics to be saved to the database.
    protected NameBasics() {
    }

    public NameBasics(String nconst, String primaryName, String birthYear, String deathYear, String primaryProfession, String knownForTitles) {

        this.nconst = nconst;
        this.primaryName = primaryName;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.primaryProfession = primaryProfession;
        this.knownForTitles = knownForTitles;
    }

    @Override
    public String toString() {
        return "NameBasics{" +
                "id=" + id +
                ", nconst='" + nconst + '\'' +
                ", primaryName='" + primaryName + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", deathYear='" + deathYear + '\'' +
                ", primaryProfession='" + primaryProfession + '\'' +
                ", knownForTitles='" + knownForTitles + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public NameBasics setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNconst() {
        return nconst;
    }

    public NameBasics setNconst(String nconst) {
        this.nconst = nconst;
        return this;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public NameBasics setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
        return this;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public NameBasics setBirthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public NameBasics setDeathYear(String deathYear) {
        this.deathYear = deathYear;
        return this;
    }

    public String getPrimaryProfession() {
        return primaryProfession;
    }

    public NameBasics setPrimaryProfession(String primaryProfession) {
        this.primaryProfession = primaryProfession;
        return this;
    }

    public String getKnownForTitles() {
        return knownForTitles;
    }

    public NameBasics setKnownForTitles(String knownForTitles) {
        this.knownForTitles = knownForTitles;
        return this;
    }
}
