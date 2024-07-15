package com.example.swp_jewelryproductionordersystem.services.interfaces;

import com.example.swp_jewelryproductionordersystem.entities.JewelryMetals;

import java.util.List;
import java.util.Optional;

public interface JewelryMetalService {
    List<JewelryMetals> findAll();

    Optional<JewelryMetals> findById(int id);

    JewelryMetals save(JewelryMetals jewelryMetals);

    void deleteById(int id);
}
