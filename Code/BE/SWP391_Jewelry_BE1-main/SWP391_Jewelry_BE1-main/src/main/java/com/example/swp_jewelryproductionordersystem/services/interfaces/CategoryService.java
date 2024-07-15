package com.example.swp_jewelryproductionordersystem.services.interfaces;

import com.example.swp_jewelryproductionordersystem.entities.Categories;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Categories> findAll();
    Categories findByIdContains(String id);
    Categories save(Categories categories);
    void deleteById(String id);
}
