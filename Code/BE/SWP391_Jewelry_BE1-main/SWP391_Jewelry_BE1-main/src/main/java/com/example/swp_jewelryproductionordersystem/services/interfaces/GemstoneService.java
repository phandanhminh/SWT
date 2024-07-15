package com.example.swp_jewelryproductionordersystem.services.interfaces;

import com.example.swp_jewelryproductionordersystem.entities.Gemstones;

import java.util.List;
import java.util.Optional;

public interface GemstoneService {
    List<Gemstones> findAll();
    Optional<Gemstones> findById(int id);
    Gemstones save(Gemstones gemstone);
    void deleteById(int id);
}
