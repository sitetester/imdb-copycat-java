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

}
