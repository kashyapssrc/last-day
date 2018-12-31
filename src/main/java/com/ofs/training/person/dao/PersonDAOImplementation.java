package com.ofs.training.person.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ofs.training.person.model.Person;

@Repository
public class PersonDAOImplementation implements PersonDAO {

    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImplementation.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addPerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
        logger.info("Person saved successfully, Person Details = " + person);
    }

    @Override
    public void updatePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(person);
        logger.info("Person updated successfully, Person Details = " + person);
    }

    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        for(Person person : personsList){
            logger.info("Person List::" + person);
        }
        return personsList;
    }

    @Override
    public Person getPersonById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Long(id));
        logger.info("Person loaded successfully, Person details = " + person);
        return person;
    }

    @Override
    public void removePerson(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Long(id));
        if(null != person){
            session.delete(person);
        }
        logger.info("Person deleted successfully, person details = " + person);
    }
}
