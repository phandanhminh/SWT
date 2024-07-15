package com.example.swp_jewelryproductionordersystem.repositories;

import com.example.swp_jewelryproductionordersystem.entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Messages, Integer> {
}
