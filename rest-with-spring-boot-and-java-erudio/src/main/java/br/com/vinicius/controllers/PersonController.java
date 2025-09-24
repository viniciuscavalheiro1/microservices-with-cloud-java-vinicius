package br.com.vinicius.controllers;

import br.com.vinicius.model.Person;
import br.com.vinicius.service.PersonService;
import org.springframework.web.bind.annotation.*;

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
    public void deletePerson(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public List<Person> findById() {
        return service.findAll();
    }
}
