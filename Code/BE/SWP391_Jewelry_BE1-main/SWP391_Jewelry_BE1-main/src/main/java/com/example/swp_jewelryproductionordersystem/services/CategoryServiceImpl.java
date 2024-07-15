package com.example.swp_jewelryproductionordersystem.services;

import com.example.swp_jewelryproductionordersystem.entities.Categories;
import com.example.swp_jewelryproductionordersystem.repositories.CategoryRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoriesRepository;

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories findByIdContains(String id) {
        return categoriesRepository.findByIdContains(id);
    }

    @Override
    public Categories save(Categories categories) {
        return categoriesRepository.save(categories);
    }

    @Override
    public void deleteById(String id) {
        categoriesRepository.deleteById(id);
    }
}
