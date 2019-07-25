package com.example.demo.service;

import com.example.demo.connector.PersonEndpointConnector;
import com.example.demo.model.Person;
import com.example.demo.property.manager.PropertyManager;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonEndpointConnector connector;
    @Autowired
    private PropertyManager propertyManager;

    private static final int TIME_TO_LEAVE = 10;


    public PersonService(PersonRepository personRepository,
                         PersonEndpointConnector connector,
                         PropertyManager propertyManager) {
        this.personRepository = personRepository;
        this.connector = connector;
        this.propertyManager = propertyManager;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void saveAll(List<Person> personList) {
        this.personRepository.saveAll(personList);
    }

    public void deleteAll() {
        this.personRepository.deleteAll();
    }

    public List<Person> saveFromUrl() {
        List<Person> personList = connector.getPersonListFromUrl(propertyManager.getUrl1());
        saveAll(personList);
        return personList;
    }

    public boolean isDBEmpty() {
        return this.personRepository.count() == 0;
    }

    public List<Person> fromDB() {
        List<Person> personListInDB = personRepository.findAll();
        if(hasExpired(personListInDB)) {
            List<Person> personList = connector.getPersonListFromUrl(propertyManager.getUrl2());
            saveAll(personList);
            return personList;
        }
        return personListInDB;
    }

    public boolean hasExpired(List<Person> personList) {
        Timestamp localDateTime = personList.get(0).getTimeStamp();
        LocalDateTime x= localDateTime.toLocalDateTime();
        Duration duration=Duration.between(localDateTime.toLocalDateTime(),LocalDateTime.now());

        Long longDuration= duration.getSeconds();

        return Duration.between(localDateTime.toLocalDateTime(),LocalDateTime.now()).getSeconds() > TIME_TO_LEAVE;
    }

}
