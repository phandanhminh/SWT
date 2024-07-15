package com.example.swp_jewelryproductionordersystem.api;

import com.example.swp_jewelryproductionordersystem.entities.JewelryMakingCharges;
import com.example.swp_jewelryproductionordersystem.services.JewelryMakingChargesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jewelrymakingcharges")
public class JewelryMakingChargesController {

    @Autowired
    private JewelryMakingChargesServiceImpl service;

    @GetMapping
    public ResponseEntity<List<JewelryMakingCharges>> getAllCharges() {
        List<JewelryMakingCharges> charges = service.findAll();
        return ResponseEntity.ok(charges);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JewelryMakingCharges> getChargeById(@PathVariable int id) {
        Optional<JewelryMakingCharges> charge = service.findById(id);
        return charge.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JewelryMakingCharges> createCharge(@RequestBody JewelryMakingCharges charge) {
        JewelryMakingCharges savedCharge = service.save(charge);
        return ResponseEntity.ok(savedCharge);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JewelryMakingCharges> updateCharge(@PathVariable int id, @RequestBody JewelryMakingCharges charge) {
        if (service.findById(id).isPresent()) {
            charge.setChargeId(id);
            JewelryMakingCharges updatedCharge = service.save(charge);
            return ResponseEntity.ok(updatedCharge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharge(@PathVariable int id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
