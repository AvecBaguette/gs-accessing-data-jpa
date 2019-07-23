package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.IPersonService;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PersonController {


    IPersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public List<Person> getPersons() {
        return personService.findAll();
    }

    public void savePerson(Person person) {
        personService.updatePerson(person);
    }


    /*PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository=personRepository;
    }
    @RequestMapping("/persons")
    public String getPersons(Model model){
        model.addAttribute("persons", personRepository.findAll());
        return "persons";
    }*/


}
