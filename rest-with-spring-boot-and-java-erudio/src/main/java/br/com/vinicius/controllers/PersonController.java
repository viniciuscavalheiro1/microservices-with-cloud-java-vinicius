package br.com.vinicius.controllers;

import br.com.vinicius.model.Person;
import br.com.vinicius.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Person> findById() {
        return service.findAll();
    }
}
