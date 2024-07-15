package com.example.swp_jewelryproductionordersystem.api;

import com.example.swp_jewelryproductionordersystem.entities.Jewelries;
import com.example.swp_jewelryproductionordersystem.services.JewelryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jewelry")
public class JewelryController {

    @Autowired
    private JewelryServiceImpl jewelryService;

    @GetMapping
    public List<Jewelries> getAllJewelry() {
        return jewelryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jewelries> getJewelryById(@PathVariable int id) {
        Optional<Jewelries> jewelry = jewelryService.findById(id);
        if (jewelry.isPresent()) {
            return ResponseEntity.ok(jewelry.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Jewelries createJewelry(@RequestBody Jewelries jewelry) {
        return jewelryService.save(jewelry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jewelries> updateJewelry(@PathVariable int id, @RequestBody Jewelries jewelryDetails) {
        Optional<Jewelries> optionalJewelry = jewelryService.findById(id);
        if (optionalJewelry.isPresent()) {
            Jewelries jewelry = optionalJewelry.get();
            jewelry.setName(jewelryDetails.getName());
            jewelry.setImage(jewelryDetails.getImage());
            jewelry.setCost(jewelryDetails.getCost());
            jewelry.setQuantity(jewelryDetails.getQuantity());
            jewelry.setStatus(jewelryDetails.isStatus());
            jewelry.setChargeId(jewelryDetails.getChargeId());
            jewelry.setQuotationId(jewelryDetails.getQuotationId());
            jewelry.setWarehouseId(jewelryDetails.getWarehouseId());
            jewelry.setSubCateId(jewelryDetails.getSubCateId());
            return ResponseEntity.ok(jewelryService.save(jewelry));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJewelry(@PathVariable int id) {
        jewelryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
