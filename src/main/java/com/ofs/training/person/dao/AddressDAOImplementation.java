package com.ofs.training.person.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ofs.training.person.model.Address;

@Repository
public class AddressDAOImplementation implements AddressDAO {

    private static final Logger logger = LoggerFactory.getLogger(AddressDAOImplementation.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addAddress(Address address) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(address);
        logger.info("Address saved successfully, Address Details = " + address);
    }

    @Override
    public void updateAddress(Address address) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(address);
        logger.info("Address updated successfully, Address Details = " + address);
    }

    @Override
    public List<Address> listAddresses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Address> addressList = session.createQuery("from Address").list();
        for(Address address : addressList){
            logger.info("Address List::" + address);
        }
        return addressList;
    }

    @Override
    public Address getAddressById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Address address = (Address) session.load(Address.class, new Long(id));
        logger.info("Address loaded successfully, Address details = " + address);
        return address;
    }

    @Override
    public void removeAddress(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Address address = (Address) session.load(Address.class, new Long(id));
        if(null != address){
            session.delete(address);
        }
        logger.info("Address deleted successfully, Address details = " + address);
    }
}
