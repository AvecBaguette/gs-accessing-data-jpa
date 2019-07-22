package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    public PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> findAll() {
        List<Person> myList = personRepository.findAll();
        return myList;
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

}
