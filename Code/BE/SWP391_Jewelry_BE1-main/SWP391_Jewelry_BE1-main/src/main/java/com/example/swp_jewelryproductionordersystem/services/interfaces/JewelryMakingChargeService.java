package com.example.swp_jewelryproductionordersystem.services.interfaces;

import com.example.swp_jewelryproductionordersystem.entities.JewelryMakingCharges;

import java.util.List;
import java.util.Optional;

public interface JewelryMakingChargeService {
    List<JewelryMakingCharges> findAll();

    Optional<JewelryMakingCharges> findById(int id);

    JewelryMakingCharges save(JewelryMakingCharges charge);

    void deleteById(int id);
}
