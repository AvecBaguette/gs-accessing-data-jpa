package com.example.demo.connector;

import com.example.demo.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class PersonEndpointConnector {

    public List<Person> getPersonListFromUrl(String url) {
        Person[] persons = new RestTemplate().getForEntity(url, Person[].class).getBody();
        return Arrays.asList(persons);
    }
}
