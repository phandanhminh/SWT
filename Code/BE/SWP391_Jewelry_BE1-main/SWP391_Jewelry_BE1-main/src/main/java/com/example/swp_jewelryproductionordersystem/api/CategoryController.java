package com.example.swp_jewelryproductionordersystem.api;

import com.example.swp_jewelryproductionordersystem.entities.Categories;
import com.example.swp_jewelryproductionordersystem.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping
    public List<Categories> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable String id) {
        Categories category = categoryService.findByIdContains(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(category);
        }
    }

    @PostMapping
    public Categories createCategory(@RequestBody Categories category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable String id, @RequestBody Categories categoryDetails) {
        Categories optionalCategory = categoryService.findByIdContains(id);
        if (optionalCategory != null) {
            Categories category = optionalCategory;
            category.setName(categoryDetails.getName());
            category.setStatus(categoryDetails.isStatus());
            return ResponseEntity.ok(categoryService.save(category));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
