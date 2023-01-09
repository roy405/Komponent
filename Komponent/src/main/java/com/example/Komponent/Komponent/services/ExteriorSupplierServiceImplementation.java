package com.example.Komponent.Komponent.services;

import com.example.Komponent.Komponent.model.ExteriorSupplier;
import com.example.Komponent.Komponent.repository.ExteriorSupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExteriorSupplierServiceImplementation implements ExteriorSupplierService {

    @Autowired
    private ExteriorSupplierRepo repository;

    @Override
    public ExteriorSupplier saveExteriorSupplier(ExteriorSupplier ExteriorSupplier) {
        return repository.save(ExteriorSupplier);
    }

    @Override
    public ExteriorSupplier getExteriorSupplierById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteExteriorSupplier(int id) {
        ExteriorSupplier ExteriorSupplier = repository.findById(id).orElse(null);
        repository.delete(ExteriorSupplier);
    }

    @Override
    public List<ExteriorSupplier> getAllExteriorSuppliers() {
        return repository.findAll();
    }
}
