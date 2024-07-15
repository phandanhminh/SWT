package com.example.swp_jewelryproductionordersystem.repositories;

import com.example.swp_jewelryproductionordersystem.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails, Integer> {
}
