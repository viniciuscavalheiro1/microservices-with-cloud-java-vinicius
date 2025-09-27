package br.com.vinicius.controllers;

import br.com.vinicius.model.Person;
import br.com.vinicius.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return service.createPerson(person);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person) {
        return service.updatePerson(person);
    }
    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Person> findById() {
        return service.findAll();
    }
}
