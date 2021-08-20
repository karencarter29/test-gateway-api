package com.example.personservice;

import java.util.List;

import org.springframework.cloud.gcp.data.spanner.repository.config.EnableSpannerRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
@EnableSpannerRepositories
public interface PersonRepository extends CrudRepository<Person, String> {
    List<Person> findByLastName(@Param("name") String name);
}