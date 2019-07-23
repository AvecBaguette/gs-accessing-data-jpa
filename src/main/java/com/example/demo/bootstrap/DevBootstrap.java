package com.example.demo.bootstrap;

import com.example.demo.controller.PersonController;
import com.example.demo.model.Person;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private PersonController personController;

    public DevBootstrap(PersonController personController) {
        this.personController = personController;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {


        Person eric = Person.create("Eric", LocalDate.of(1999, 4, 22));
        personController.savePerson(eric);


        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://www.mocky.io/v2/5d35bb0a56000056003a4fdf";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

        ResponseEntity<Person[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Person[].class);
        Person[] persons = responseEntity.getBody();

        for (Person person : persons) {
            //System.out.println("Name:" + person.getName() + ", BirthDate:" + person.getBirthDate());
            Person newPerson = Person.create(person.getName(), person.getBirthDate());
            personController.savePerson(newPerson);
        }


        List<Person> personList = personController.getPersons();
        System.out.println(personList);
    }
}
