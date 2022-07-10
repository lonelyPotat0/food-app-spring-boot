package com.dom.food.category.services;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dom.food.category.mapper.CategoryMapper;
import com.dom.food.category.models.CategoryModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    // @Autowired
    private final CategoryMapper categoryMapper;

    public static final String deleteCategory = null;

    public ResponseEntity<?> createCategory(CategoryModel categoryModel) {
        categoryModel.setCategoryName(categoryModel.getCategoryName().toLowerCase());

        if (this.existByName(categoryModel)) {
            return ResponseEntity.badRequest().body("category already exist");
        }
        return this.categoryMapper.createCategory(categoryModel) ? ResponseEntity.ok().body("created")
                : ResponseEntity.badRequest().body("failed");
    }

    public ResponseEntity<?> getCategory(Integer id) {
        return ResponseEntity.ok().body(this.categoryMapper.getCategory(id));
    }

    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.ok().body(this.categoryMapper.getAllCategory());
    }

    public ResponseEntity<?> updateCategory(CategoryModel categoryModel) {
        if (this.existByName(categoryModel)) {
            return ResponseEntity.badRequest().body("category already exist");
        }
        return this.categoryMapper.updateCategory(categoryModel) ? ResponseEntity.ok().body("updated")
                : ResponseEntity.badRequest().body("failed");
    }

    public ResponseEntity<?> deleteCategory(Integer id) {
        return this.categoryMapper.deleteCategory(id) ? ResponseEntity.ok().body("deleted")
                : ResponseEntity.badRequest().body("failed");
    }

    private boolean existByName(CategoryModel categoryModel) {
        return this.categoryMapper.existsByName(categoryModel);
    }

}
