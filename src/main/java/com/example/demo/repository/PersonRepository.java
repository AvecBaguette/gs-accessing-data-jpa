package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query("select * from person where name= :name")
    List<Person> findByName(@Param("name") String name);


    List<Person> findAll();


}
