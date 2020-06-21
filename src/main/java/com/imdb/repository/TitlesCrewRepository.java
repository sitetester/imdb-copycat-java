package com.imdb.repository;

import com.imdb.entity.TitlesCrew;
import org.springframework.data.repository.CrudRepository;

public interface TitlesCrewRepository extends CrudRepository<TitlesCrew, Long> {

    TitlesCrew findById(long id);
}
