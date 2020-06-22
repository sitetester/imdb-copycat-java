package com.imdb.repository;

import com.imdb.entity.TitleBasics;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TitleBasicsRepository extends CrudRepository<TitleBasics, Long> {

    TitleBasics findById(long id);

    Optional<TitleBasics> findByOriginalTitle(String originalTitle);

    Optional<TitleBasics> findByGenres(String genres);


}