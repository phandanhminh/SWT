package com.example.swp_jewelryproductionordersystem.services.interfaces;

import com.example.swp_jewelryproductionordersystem.entities.Warehouses;

import java.util.List;

public interface WarehouseService {
    Warehouses saveWarehouse(Warehouses warehouse);
    Warehouses updateWarehouse(Warehouses warehouse);
    void deleteWarehouse(int id);
    Warehouses getWarehouseById(int id);
    List<Warehouses> getAllWarehouses();
}
