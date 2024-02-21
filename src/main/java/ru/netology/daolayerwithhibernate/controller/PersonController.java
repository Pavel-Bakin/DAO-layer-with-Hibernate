package ru.netology.daolayerwithhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.daolayerwithhibernate.model.Person;
import ru.netology.daolayerwithhibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam(required = false) String city) {
        if (city == null || city.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            List<Person> persons = personRepository.findByCityOfLiving(city);
            return ResponseEntity.ok(persons);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/persons/by-age")
    public ResponseEntity<List<Person>> getPersonsByAge(@RequestParam int age) {
        try {
            List<Person> persons = personRepository.findByAgeLessThanOrderByAgeAsc(age);
            return ResponseEntity.ok(persons);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/persons/by-name-and-surname")
    public ResponseEntity<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        try {
            Optional<Person> person = personRepository.findByNameAndSurname(name, surname);
            return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}