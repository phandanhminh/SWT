package com.example.swp_jewelryproductionordersystem.services;

import com.example.swp_jewelryproductionordersystem.entities.JewelryMakingCharges;
import com.example.swp_jewelryproductionordersystem.repositories.JewelryMakingChargesRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.JewelryMakingChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryMakingChargesServiceImpl implements JewelryMakingChargeService {
    @Autowired
    private JewelryMakingChargesRepository repository;

    public List<JewelryMakingCharges> findAll() {
        return repository.findAll();
    }

    public Optional<JewelryMakingCharges> findById(int id) {
        return repository.findById(id);
    }

    public JewelryMakingCharges save(JewelryMakingCharges charge) {
        return repository.save(charge);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
