package com.ofs.training.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ofs.training.person.model.Address;
import com.ofs.training.person.model.Person;
import com.ofs.training.person.service.AddressService;

public class AddressController {

    @Autowired
    private AddressService addressService;

    @Qualifier(value = "addressService")
    public void setAddressService(AddressService addressService){
        this.addressService = addressService;
    }

    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.addressService.listAddresses());
        return "address";
    }

    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addAddress(@ModelAttribute("address") Address address){

        if (address.getId() == 0){
            this.addressService.addAddress(address);
        } else {
            this.addressService.updateAddress(address);
        }
        return "redirect:/addresses";
    }

    @RequestMapping("/remove/{id}")
    public String removeAddress(@PathVariable("id") int id){
        this.addressService.removeAddress(id);
        return "redirect:/addresses";
    }

    @RequestMapping("/edit/{id}")
    public String editAddress(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.addressService.getAddressById(id));
        model.addAttribute("listPersons", this.addressService.listAddresses());
        return "address";
    }
}
