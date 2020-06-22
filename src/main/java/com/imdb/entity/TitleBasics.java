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


    protected TitleBasics() {
    }

    public TitleBasics(
            String tconst,
            String titleType,
            String primaryTitle,
            String originalTitle,
            String isAdult,
            String startYear,
            String endYear,
            String runtimeMinutes,
            String genres) {

        this.tconst = tconst;
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
        this.isAdult = isAdult;
        this.startYear = startYear;
        this.endYear = endYear;
        this.runtimeMinutes = runtimeMinutes;
        this.genres = genres;
    }

    public Long getId() {
        return id;
    }

    public TitleBasics setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTconst() {
        return tconst;
    }

    public TitleBasics setTconst(String tconst) {
        this.tconst = tconst;
        return this;
    }

    public String getTitleType() {
        return titleType;
    }

    public TitleBasics setTitleType(String titleType) {
        this.titleType = titleType;
        return this;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public TitleBasics setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
        return this;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public TitleBasics setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    public String getIsAdult() {
        return isAdult;
    }

    public TitleBasics setIsAdult(String isAdult) {
        this.isAdult = isAdult;
        return this;
    }

    public String getStartYear() {
        return startYear;
    }

    public TitleBasics setStartYear(String startYear) {
        this.startYear = startYear;
        return this;
    }

    public String getEndYear() {
        return endYear;
    }

    public TitleBasics setEndYear(String endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public TitleBasics setRuntimeMinutes(String runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
        return this;
    }

    public String getGenres() {
        return genres;
    }

    public TitleBasics setGenres(String genres) {
        this.genres = genres;
        return this;
    }
}
