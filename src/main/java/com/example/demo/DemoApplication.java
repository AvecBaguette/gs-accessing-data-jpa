package com.example.demo;

import com.example.demo.controller.PersonController;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);


    }


    @Bean
    ApplicationRunner applicationRunner(PersonRepository personRepository) {
        return args -> {
            //PersonService personService = new PersonService();
            PersonService personService = new PersonService(personRepository);
            PersonController personController = new PersonController(personService);


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
                //personRepository.save(newPerson);
                personController.savePerson(newPerson);
            }


            List<Person> personList = personController.getPersons();
            System.out.println(personList);
        };
    }

}



