package com.example.Komponent.Komponent.RESTController;

import com.example.Komponent.Komponent.model.ExteriorSupplier;
import com.example.Komponent.Komponent.services.ExteriorSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/exteriorSupplier")
public class ExteriorSupplierController {

    @Autowired
    private ExteriorSupplierService ExteriorSupplierService;

    public List<ExteriorSupplier> getExteriorSuppliers() {
        return ExteriorSupplierService.getAllExteriorSuppliers();
    }

    @GetMapping("/{id}")
    public ExteriorSupplier getExteriorSupplier(@PathVariable("id") int id) {
        return ExteriorSupplierService.getExteriorSupplierById(id);
    }

    @PostMapping
    public ExteriorSupplier createExteriorSupplier(@RequestBody ExteriorSupplier exteriorSupplier) {
        return ExteriorSupplierService.saveExteriorSupplier(exteriorSupplier);
    }
    @PutMapping
    public ExteriorSupplier updateExteriorSupplier(@RequestBody ExteriorSupplier exteriorSupplier) {
        return ExteriorSupplierService.saveExteriorSupplier(exteriorSupplier);
    }
    @DeleteMapping("/{id}")
    public void deleteExteriorSupplier(@PathVariable("id") int id) {
        ExteriorSupplierService.deleteExteriorSupplier(id);
    }
}
