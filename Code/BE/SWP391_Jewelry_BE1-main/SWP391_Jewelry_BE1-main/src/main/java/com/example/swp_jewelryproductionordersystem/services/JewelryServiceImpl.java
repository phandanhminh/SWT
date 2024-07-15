package com.example.swp_jewelryproductionordersystem.services;

import com.example.swp_jewelryproductionordersystem.entities.Jewelries;
import com.example.swp_jewelryproductionordersystem.repositories.JewelryRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.JewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryServiceImpl implements JewelryService {
    @Autowired
    private JewelryRepository jewelryRepository;

    @Override
    public List<Jewelries> findAll() {
        return jewelryRepository.findAll();
    }

    @Override
    public Optional<Jewelries> findById(int id) {
        return jewelryRepository.findById(id);
    }

    @Override
    public Jewelries save(Jewelries jewelry) {
        return jewelryRepository.save(jewelry);
    }

    @Override
    public void deleteById(int id) {
        jewelryRepository.deleteById(id);
    }
}
