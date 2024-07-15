package com.example.swp_jewelryproductionordersystem.api;

import com.example.swp_jewelryproductionordersystem.entities.Shippings;
import com.example.swp_jewelryproductionordersystem.services.interfaces.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shippings")
public class ShippingController {

    @Autowired
    private ShippingService shippingsService;

    @PostMapping
    public ResponseEntity<Shippings> createShipping(@RequestBody Shippings shippings) {
        Shippings createdShippings = shippingsService.saveShipping(shippings);
        return ResponseEntity.ok(createdShippings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shippings> updateShipping(@PathVariable int id, @RequestBody Shippings shippings) {
        shippings.setId(id);
        Shippings updatedShippings = shippingsService.updateShipping(shippings);
        return ResponseEntity.ok(updatedShippings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipping(@PathVariable int id) {
        shippingsService.deleteShipping(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shippings> getShippingById(@PathVariable int id) {
        Shippings shippings = shippingsService.getShippingById(id);
        return ResponseEntity.ok(shippings);
    }

    @GetMapping
    public ResponseEntity<List<Shippings>> getAllShippings() {
        List<Shippings> shippings = shippingsService.getAllShippings();
        return ResponseEntity.ok(shippings);
    }
}
