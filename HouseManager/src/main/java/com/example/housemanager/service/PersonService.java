package com.example.housemanager.service;

import com.example.housemanager.model.Person;
import com.example.housemanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAll() {
        return this.personRepository.findAll();
    }

    public Person getById(Integer id) {
        Optional<Person> personOptional = this.personRepository.findById(id);
        if (!personOptional.isPresent()) {
            System.out.println("Person with id " + id + " does not exist in the database.");
            return null;
        }
        return personOptional.get();
    }

    public void save(Person person) {
        this.personRepository.saveAndFlush(person);
    }

    public void deleteById(Integer id) {
        this.personRepository.deleteById(id);
    }
}
