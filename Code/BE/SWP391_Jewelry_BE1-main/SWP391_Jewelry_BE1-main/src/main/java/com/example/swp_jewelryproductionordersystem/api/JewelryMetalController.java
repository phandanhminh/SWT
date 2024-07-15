package com.example.swp_jewelryproductionordersystem.api;

import com.example.swp_jewelryproductionordersystem.entities.JewelryMetals;
import com.example.swp_jewelryproductionordersystem.services.JewelryMetalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jewelrymetals")
public class JewelryMetalController {

    @Autowired
    private JewelryMetalServiceImpl service;

    @GetMapping
    public ResponseEntity<List<JewelryMetals>> getAllJewelryMetals() {
        List<JewelryMetals> jewelryMetalsList = service.findAll();
        return ResponseEntity.ok(jewelryMetalsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JewelryMetals> getJewelryMetalsById(@PathVariable int id) {
        Optional<JewelryMetals> jewelryMetals = service.findById(id);
        return jewelryMetals.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JewelryMetals> createJewelryMetals(@RequestBody JewelryMetals jewelryMetals) {
        JewelryMetals savedJewelryMetals = service.save(jewelryMetals);
        return ResponseEntity.ok(savedJewelryMetals);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JewelryMetals> updateJewelryMetals(@PathVariable int id, @RequestBody JewelryMetals jewelryMetals) {
        if (service.findById(id).isPresent()) {
            jewelryMetals.setJewelryId(id);
            JewelryMetals updatedJewelryMetals = service.save(jewelryMetals);
            return ResponseEntity.ok(updatedJewelryMetals);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJewelryMetals(@PathVariable int id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
