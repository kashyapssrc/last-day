package com.ofs.training.person.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ofs.training.person.dao.PersonDAO;
import com.ofs.training.person.model.Person;

@Service
public class PersonServiceImplementation implements PersonService {

    private PersonDAO personDAO;

    @Override
    @Transactional
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Override
    @Transactional
    public void addPerson(Person person) {
        this.personDAO.addPerson(person);
    }


    @Override
    @Transactional
    public void updatePerson(Person person) {
        this.personDAO.updatePerson(person);
    }


    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }


    @Override
    @Transactional
    public Person getPersonById(long id) {
        return this.personDAO.getPersonById(id);
    }


    @Override
    @Transactional
    public void removePerson(long id) {
        this.personDAO.removePerson(id);
    }
}