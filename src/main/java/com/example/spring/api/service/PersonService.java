package com.example.spring.api.service;

import com.example.spring.api.dao.PersonDao;
import com.example.spring.api.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("Postgre") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPersons() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return (Optional<Person>) personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person person) {
        return personDao.updatePersonById(id, person);
    }
}
