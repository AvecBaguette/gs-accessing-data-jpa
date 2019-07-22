package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;

public interface IPersonService {


    public List<Person> findAll();

    public void updatePerson(Person person);
}
