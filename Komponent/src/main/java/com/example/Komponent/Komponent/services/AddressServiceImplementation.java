package com.example.Komponent.Komponent.services;


import com.example.Komponent.Komponent.model.Address;
import com.example.Komponent.Komponent.repository.AddressRepo;
import com.example.Komponent.Komponent.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImplementation implements AddressService {

    @Autowired
    private AddressRepo repository;
    @Override
    public Address saveAddress(Address Address) {
        return repository.save(Address);
    }

    @Override
    public Address getAddressById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteAddress(int id) {
        Address Address = repository.findById(id).orElse(null);
        repository.delete(Address);
    }

    @Override
    public List<Address> getAllAddresses() {
        return repository.findAll();
    }
}


