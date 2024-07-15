package com.example.swp_jewelryproductionordersystem.api;

import com.example.swp_jewelryproductionordersystem.entities.SubCategories;
import com.example.swp_jewelryproductionordersystem.services.interfaces.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoriesService;

    @PostMapping
    public ResponseEntity<SubCategories> createSubCategory(@RequestBody SubCategories subCategory) {
        SubCategories createdSubCategory = subCategoriesService.saveSubCategory(subCategory);
        return ResponseEntity.ok(createdSubCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategories> updateSubCategory(@PathVariable String id, @RequestBody SubCategories subCategory) {
        subCategory.setId(id);
        SubCategories updatedSubCategory = subCategoriesService.updateSubCategory(subCategory);
        return ResponseEntity.ok(updatedSubCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable String id) {
        subCategoriesService.deleteSubCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategories> getSubCategoryById(@PathVariable String id) {
        SubCategories subCategory = subCategoriesService.getSubCategoryById(id);
        return ResponseEntity.ok(subCategory);
    }

    @GetMapping
    public ResponseEntity<List<SubCategories>> getAllSubCategories() {
        List<SubCategories> subCategories = subCategoriesService.getAllSubCategories();
        return ResponseEntity.ok(subCategories);
    }
}
