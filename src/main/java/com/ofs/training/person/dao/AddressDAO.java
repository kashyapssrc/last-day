package com.ofs.training.person.dao;

import java.util.List;

import com.ofs.training.person.model.Address;

public interface AddressDAO {

    public void addAddress(Address address);
    public void updateAddress(Address address);
    public List<Address> listAddresses();
    public Address getAddressById(long id);
    public void removeAddress(long id);
}
