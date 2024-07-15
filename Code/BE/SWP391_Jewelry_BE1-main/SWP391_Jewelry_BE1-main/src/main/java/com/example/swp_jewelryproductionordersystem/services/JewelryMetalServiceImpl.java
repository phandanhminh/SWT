package com.example.swp_jewelryproductionordersystem.services;

import com.example.swp_jewelryproductionordersystem.entities.JewelryMetals;
import com.example.swp_jewelryproductionordersystem.repositories.JewelryMetalRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.JewelryMetalService;
import com.example.swp_jewelryproductionordersystem.services.interfaces.JewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryMetalServiceImpl implements JewelryMetalService {

    @Autowired
    private JewelryMetalRepository repository;

    @Override
    public List<JewelryMetals> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<JewelryMetals> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public JewelryMetals save(JewelryMetals jewelryMetals) {
        return repository.save(jewelryMetals);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
