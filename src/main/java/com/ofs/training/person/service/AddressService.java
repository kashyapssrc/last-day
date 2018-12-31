package com.ofs.training.person.service;

import java.util.List;

import com.ofs.training.person.dao.AddressDAO;
import com.ofs.training.person.model.Address;

public interface AddressService {
    public void addAddress(Address address);
    public void updateAddress(Address address);
    public List<Address> listAddresses();
    public Address getAddressById(long id);
    public void removeAddress(long id);
    void setAddressDAO(AddressDAO addressDAO);
}
