package com.example.swp_jewelryproductionordersystem.services;

import com.example.swp_jewelryproductionordersystem.entities.Gemstones;
import com.example.swp_jewelryproductionordersystem.repositories.GemstoneRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.GemstoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GemstoneServiceImpl implements GemstoneService {
    @Autowired
    private GemstoneRepository gemstoneRepository;

    @Override
    public List<Gemstones> findAll() {
        return gemstoneRepository.findAll();
    }

    @Override
    public Optional<Gemstones> findById(int id) {
        return gemstoneRepository.findById(id);
    }

    @Override
    public Gemstones save(Gemstones gemstone) {
        return gemstoneRepository.save(gemstone);
    }

    @Override
    public void deleteById(int id) {
        gemstoneRepository.deleteById(id);
    }
}
