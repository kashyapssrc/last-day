package com.ofs.training.person.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ofs.training.person.dao.AddressDAO;
import com.ofs.training.person.model.Address;

public class AddressServiceImplementation implements AddressService {
    private AddressDAO addressDAO;

    @Override
    @Transactional
    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }


    @Override
    @Transactional
    public void addAddress(Address address) {
        this.addressDAO.addAddress(address);
    }


    @Override
    @Transactional
    public void updateAddress(Address address) {
        this.addressDAO.updateAddress(address);
    }


    @Override
    @Transactional
    public List<Address> listAddresses() {
        return this.addressDAO.listAddresses();
    }


    @Override
    @Transactional
    public Address getAddressById(long id) {
        return this.addressDAO.getAddressById(id);
    }


    @Override
    @Transactional
    public void removeAddress(long id) {
        this.addressDAO.removeAddress(id);
    }
}
