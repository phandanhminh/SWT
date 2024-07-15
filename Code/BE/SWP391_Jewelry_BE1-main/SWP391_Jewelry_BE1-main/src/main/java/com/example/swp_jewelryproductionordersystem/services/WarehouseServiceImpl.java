package com.example.swp_jewelryproductionordersystem.services;

import com.example.swp_jewelryproductionordersystem.entities.Warehouses;
import com.example.swp_jewelryproductionordersystem.repositories.WarehouseRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehousesRepository;

    @Override
    public Warehouses saveWarehouse(Warehouses warehouse) {
        return warehousesRepository.save(warehouse);
    }

    @Override
    public Warehouses updateWarehouse(Warehouses warehouse) {
        return warehousesRepository.save(warehouse);
    }

    @Override
    public void deleteWarehouse(int id) {
        warehousesRepository.deleteById(id);
    }

    @Override
    public Warehouses getWarehouseById(int id) {
        Optional<Warehouses> optionalWarehouse = warehousesRepository.findById(id);
        return optionalWarehouse.orElse(null);
    }

    @Override
    public List<Warehouses> getAllWarehouses() {
        return warehousesRepository.findAll();
    }
}
