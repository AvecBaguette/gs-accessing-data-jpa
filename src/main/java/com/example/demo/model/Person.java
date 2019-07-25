package com.example.demo.model;


import javafx.util.converter.TimeStringConverter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TooManyListenersException;

@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private LocalDate birthDate;
    @Version
    @Type(type="dbtimestamp")
    private Timestamp timeStamp;

    public Person() {
    }

    public Person(Long id, String name, LocalDate birthDate) {

        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public void setIdd(Long id) {
        this.id = id;
    }


    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public void setTimeStamp(Timestamp timeStamp){
        this.timeStamp=timeStamp;
    }

    public Timestamp getTimeStamp(){
        return timeStamp;
    }

    public void setBirthDate(LocalDate birthDate) {
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
