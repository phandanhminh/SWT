package com.example.swp_jewelryproductionordersystem.repositories;

import com.example.swp_jewelryproductionordersystem.entities.Gemstones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GemstoneRepository extends JpaRepository<Gemstones, Integer> {
}
