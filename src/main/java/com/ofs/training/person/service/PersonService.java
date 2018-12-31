package com.ofs.training.person.service;

import java.util.List;

import com.ofs.training.person.dao.PersonDAO;
import com.ofs.training.person.model.Person;

public interface PersonService {
    public void addPerson(Person person);
    public void updatePerson(Person person);
    public List<Person> listPersons();
    public Person getPersonById(long id);
    public void removePerson(long id);
    void setPersonDAO(PersonDAO personDAO);
}