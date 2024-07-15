package com.example.swp_jewelryproductionordersystem.services.interfaces;

import com.example.swp_jewelryproductionordersystem.entities.SubCategories;

import java.util.List;

public interface SubCategoryService {
    SubCategories saveSubCategory(SubCategories subCategory);
    SubCategories updateSubCategory(SubCategories subCategory);
    void deleteSubCategory(String id);
    SubCategories getSubCategoryById(String id);
    List<SubCategories> getAllSubCategories();
}
