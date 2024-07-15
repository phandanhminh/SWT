package com.example.swp_jewelryproductionordersystem.repositories;

import com.example.swp_jewelryproductionordersystem.entities.Quotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationRepository extends JpaRepository<Quotations, Integer> {
}