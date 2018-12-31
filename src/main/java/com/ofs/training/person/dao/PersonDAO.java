package com.ofs.training.person.dao;

import java.util.List;

import com.ofs.training.person.model.Person;

public interface PersonDAO {

    public void addPerson(Person person);
    public void updatePerson(Person person);
    public List<Person> listPersons();
    public Person getPersonById(long id);
    public void removePerson(long id);
}
