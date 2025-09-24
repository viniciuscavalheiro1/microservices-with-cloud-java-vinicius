package br.com.vinicius.service;

import br.com.vinicius.exception.ResourceNotFoundException;
import br.com.vinicius.model.Person;
import br.com.vinicius.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person) {
        logger.info("Creating person: " + person);
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        Person entity =  personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this person ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        logger.info("Update person: " + entity);
        return personRepository.save(entity);
    }

    public Person findById(Long id) {
        logger.info("Finding one person!");
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this person ID!"));
    }

    public List<Person> findAll() {
        logger.info("Finding all persons!");
        return personRepository.findAll();
    }

    public void deleteById(Long id) {
        Person entity =  personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this person ID!"));
        personRepository.delete(entity);
    }
}
