package com.imdb.entity;

import javax.persistence.*;

@Entity
@Table(name = "title_ratings")
public class TitleRatings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String tconst;
    String averageRating;
    int numVotes;


    protected TitleRatings() {
    }

    public TitleRatings(String tconst, String averageRating, int numVotes) {

        this.tconst = tconst;
        this.averageRating = averageRating;
        this.numVotes = numVotes;
    }

    public Long getId() {
        return id;
    }

    public TitleRatings setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTconst() {
        return tconst;
    }

    public TitleRatings setTconst(String tconst) {
        this.tconst = tconst;
        return this;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public TitleRatings setAverageRating(String averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    public int getNumVotes() {
        return numVotes;
    }

    public TitleRatings setNumVotes(int numVotes) {
        this.numVotes = numVotes;
        return this;
    }
}
