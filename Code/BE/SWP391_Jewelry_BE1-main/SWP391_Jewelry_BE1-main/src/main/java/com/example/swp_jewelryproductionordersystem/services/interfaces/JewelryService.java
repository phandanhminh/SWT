package com.example.swp_jewelryproductionordersystem.services.interfaces;

import com.example.swp_jewelryproductionordersystem.entities.Jewelries;

import java.util.List;
import java.util.Optional;

public interface JewelryService {
    List<Jewelries> findAll();
    Optional<Jewelries> findById(int id);
    Jewelries save(Jewelries jewelry);
    void deleteById(int id);
}
