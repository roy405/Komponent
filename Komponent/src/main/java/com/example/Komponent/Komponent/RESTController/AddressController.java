package com.example.Komponent.Komponent.RESTController;


import com.example.Komponent.Komponent.model.Address;
import com.example.Komponent.Komponent.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService AddressService;

    @GetMapping
    public List<Address> getAddresses() {
        return AddressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable("id") int id) {
        return AddressService.getAddressById(id);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return AddressService.saveAddress(address);
    }
    @PutMapping
    public Address updateAddress(@RequestBody Address address) {
        return AddressService.saveAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id") int id) {
        AddressService.deleteAddress(id);
    }
}
