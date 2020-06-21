package com.imdb.repository;

import com.imdb.entity.NameBasics;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The type of entity and ID that it works with, NameBasics and Long, are specified in the generic parameters on CrudRepository.
 * By extending CrudRepository, NameBasicsRepository inherits several methods for working with NameBasics persistence,
 * including methods for saving, deleting, and finding Customer entities.
 */
public interface NameBasicsRepository extends CrudRepository<NameBasics, Long> {

    NameBasics findById(long id);

    List<NameBasics> findBynconst(String nconst);
}