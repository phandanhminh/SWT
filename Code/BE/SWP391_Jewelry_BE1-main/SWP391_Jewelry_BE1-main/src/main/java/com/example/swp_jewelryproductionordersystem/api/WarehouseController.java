package com.example.swp_jewelryproductionordersystem.api;

import com.example.swp_jewelryproductionordersystem.entities.Warehouses;
import com.example.swp_jewelryproductionordersystem.services.interfaces.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehousesService;

    @PostMapping
    public ResponseEntity<Warehouses> createWarehouse(@RequestBody Warehouses warehouse) {
        Warehouses createdWarehouse = warehousesService.saveWarehouse(warehouse);
        return ResponseEntity.ok(createdWarehouse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouses> updateWarehouse(@PathVariable int id, @RequestBody Warehouses warehouse) {
        warehouse.setId(id);
        Warehouses updatedWarehouse = warehousesService.updateWarehouse(warehouse);
        return ResponseEntity.ok(updatedWarehouse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable int id) {
        warehousesService.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouses> getWarehouseById(@PathVariable int id) {
        Warehouses warehouse = warehousesService.getWarehouseById(id);
        return ResponseEntity.ok(warehouse);
    }

    @GetMapping
    public ResponseEntity<List<Warehouses>> getAllWarehouses() {
        List<Warehouses> warehouses = warehousesService.getAllWarehouses();
        return ResponseEntity.ok(warehouses);
    }
}