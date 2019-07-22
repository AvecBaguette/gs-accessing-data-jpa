package com.example.demo.model;

import org.springframework.data.annotation.Id;


import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Person {
    @Id
    private Long id;
    private String name;
    private LocalDate birthDate;

    protected Person() {
    }


    public Person(Long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }


    public static Person create(String name, LocalDate birthDate) {
        return new Person(null, name, birthDate);
    }

    void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name=" + name +
                ", birthDate=" + birthDate +
                '}';
    }
}
