package com.example.swp_jewelryproductionordersystem.services;

import com.example.swp_jewelryproductionordersystem.entities.SubCategories;
import com.example.swp_jewelryproductionordersystem.repositories.SubCategoryRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public SubCategories saveSubCategory(SubCategories subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategories updateSubCategory(SubCategories subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public void deleteSubCategory(String id) {
        subCategoryRepository.deleteById(id);
    }

    @Override
    public SubCategories getSubCategoryById(String id) {
        Optional<SubCategories> optionalSubCategory = subCategoryRepository.findById(id);
        return optionalSubCategory.orElse(null);
    }

    @Override
    public List<SubCategories> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }
}
