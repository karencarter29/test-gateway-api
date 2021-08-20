package com.example.personservice.web.controllers;

import com.example.personservice.Person;
import com.example.personservice.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class PersonController {

    @Autowired
    public HelloFeignClient helloFeignClient;

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable(name="id") String id) {
        Person p = personRepository.findById(id).get();
        return helloFeignClient.hello(p.getFirstName() + " " + p.getLastName());
    }

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public String start() {
        return "Welcome to PERSON-SERVICE!";
    }

    @GetMapping("/create/{first_name}/{last_name}")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@PathVariable(name="first_name") String firstname,
                       @PathVariable(name="last_name") String lastname) {
        Person p = new Person(UUID.randomUUID().toString(), firstname, lastname);
        personRepository.save(p);
        return "CREATED SUCCESSFULLY";
    }

    @GetMapping("/update/{id}/firstname/{firstname}")
    @ResponseStatus(HttpStatus.OK)
    public String updateFirstname(@PathVariable(name="id") String id,
                                @PathVariable(name="firstname") String firstname) {
        Person p = personRepository.findById(id).get();
        p.setFirstName(firstname);
        personRepository.save(p);
        return "FIRSTNAME UPDATED SUCCESSFULLY";
    }

    @GetMapping(value = "/update/{id}/lastname/{lastname}")
    public String updateLastname(@PathVariable(name="id") String id,
                               @PathVariable(name="lastname") String lastname) {
        Person p = personRepository.findById(id).get();
        p.setLastName(lastname);
        personRepository.save(p);
        return "LASTNAME UPDATED SUCCESSFULLY";
    }

    @GetMapping("/find/{id}")
    public Person findById(@PathVariable(name="id") String id) {
        return personRepository.findById(id).get();
    }

    @GetMapping("/findAll")
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        return people;
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name="id") String id) {
        personRepository.deleteById(id);
        return "DELETED SUCCESSFULLY";
    }
}
