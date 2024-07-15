package com.example.swp_jewelryproductionordersystem.repositories;
import com.example.swp_jewelryproductionordersystem.entities.SubCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategories, String> {

}
