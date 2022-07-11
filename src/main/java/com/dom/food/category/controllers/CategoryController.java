package com.dom.food.category.controllers;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dom.food.category.models.CategoryModel;
import com.dom.food.category.services.CategoryService;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    CategoryService categoryrService;

    // public CategoryController(CategoryService categoryrService) {
    // this.categoryrService = categoryrService;
    // }

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryModel categoryModel) {
        return this.categoryrService.createCategory(categoryModel);
    }

    @GetMapping()
    public List<Object> getAllCategory() {
        return this.categoryrService.getAllCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable("id") String id) {
        return this.categoryrService.getCategory(Integer.parseInt(id));
    }

    @PutMapping()
    public ResponseEntity<?> updateCategory(@RequestBody CategoryModel categoryModel) {
        return this.categoryrService.updateCategory(categoryModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") String id) {
        return this.categoryrService.deleteCategory(Integer.parseInt(id));
    }
}
