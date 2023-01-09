package com.example.Komponent.Komponent.services;

import com.example.Komponent.Komponent.model.Address;

import java.util.List;


public interface AddressService {

        Address saveAddress(Address Address);

        Address getAddressById(int id);

        void deleteAddress(int id);

        List<Address> getAllAddresses();
}
