package com.imdb.repository;

import com.imdb.entity.TitlePrincipals;
import org.springframework.data.repository.CrudRepository;

public interface TitlePrincipalsRepository extends CrudRepository<TitlePrincipals, Long> {

    TitlePrincipals findById(long id);

}
