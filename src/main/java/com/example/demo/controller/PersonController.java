package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> showPersons() {
        if(personService.isDBEmpty()) {
            return this.personService.saveFromUrl();
        }
        return this.personService.fromDB();
    }



        /*List<Person> personList= personService.findAll();

        String body=personList
                .stream()
                .map(e -> e.toString())
                .collect(Collectors.joining(","));



        return body;
        */

//    }

}
