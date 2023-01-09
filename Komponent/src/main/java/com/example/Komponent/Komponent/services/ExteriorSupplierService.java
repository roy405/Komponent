package com.example.Komponent.Komponent.services;

import com.example.Komponent.Komponent.model.ExteriorSupplier;;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ExteriorSupplierService {

    ExteriorSupplier saveExteriorSupplier(ExteriorSupplier ExteriorSupplier);

    ExteriorSupplier getExteriorSupplierById(int id);

    void deleteExteriorSupplier(int id);

    List<ExteriorSupplier> getAllExteriorSuppliers();
}
