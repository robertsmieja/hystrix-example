package com.robertsmieja.examples.hystrix.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StringRepository extends CrudRepository<String, Long>, PagingAndSortingRepository<String, Long> {
}
