package com.imdb.repository;

import com.imdb.entity.TitleBasics;
import org.springframework.data.repository.CrudRepository;

public interface TitleBasicsRepository extends CrudRepository<TitleBasics, Long> {

    TitleBasics findById(long id);

}