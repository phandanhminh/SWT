package com.example.swp_jewelryproductionordersystem.api;

import com.example.swp_jewelryproductionordersystem.entities.Gemstones;
import com.example.swp_jewelryproductionordersystem.services.GemstoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gemstones")
public class GemstoneController {

    @Autowired
    private GemstoneServiceImpl gemstoneService;

    @GetMapping
    public List<Gemstones> getAllGemstones() {
        return gemstoneService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gemstones> getGemstoneById(@PathVariable int id) {
        Optional<Gemstones> gemstone = gemstoneService.findById(id);
        if (gemstone.isPresent()) {
            return ResponseEntity.ok(gemstone.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Gemstones createGemstone(@RequestBody Gemstones gemstone) {
        return gemstoneService.save(gemstone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gemstones> updateGemstone(@PathVariable int id, @RequestBody Gemstones gemstoneDetails) {
        Optional<Gemstones> optionalGemstone = gemstoneService.findById(id);
        if (optionalGemstone.isPresent()) {
            Gemstones gemstone = optionalGemstone.get();
            gemstone.setName(gemstoneDetails.getName());
            gemstone.setImage(gemstoneDetails.getImage());
            gemstone.setStatus(gemstoneDetails.isStatus());
            gemstone.setJewelryId(gemstoneDetails.getJewelryId());
            return ResponseEntity.ok(gemstoneService.save(gemstone));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGemstone(@PathVariable int id) {
        gemstoneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
