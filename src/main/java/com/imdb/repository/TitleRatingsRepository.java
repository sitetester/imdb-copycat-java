package com.imdb.repository;

import com.imdb.entity.TitleRatings;
import org.springframework.data.repository.CrudRepository;

public interface TitleRatingsRepository extends CrudRepository<TitleRatings, Long> {

    TitleRatings findById(long id);
}
