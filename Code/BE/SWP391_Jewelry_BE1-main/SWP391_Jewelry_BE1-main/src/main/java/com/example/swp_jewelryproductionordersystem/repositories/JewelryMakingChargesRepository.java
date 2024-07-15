package com.example.swp_jewelryproductionordersystem.repositories;

import com.example.swp_jewelryproductionordersystem.entities.JewelryMakingCharges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelryMakingChargesRepository extends JpaRepository<JewelryMakingCharges, Integer> {
}
