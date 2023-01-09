package com.example.Komponent.Komponent.repository;

import com.example.Komponent.Komponent.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepo extends JpaRepository<Address, Integer> {
}
