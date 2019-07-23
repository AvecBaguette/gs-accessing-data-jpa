package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;

public interface IPersonService {


    List<Person> findAll();

    void updatePerson(Person person);
}
