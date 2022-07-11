package com.dom.food.category.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dom.food.category.mapper.CategoryMapper;
import com.dom.food.category.models.CategoryModel;

// import lombok.RequiredArgsConstructor;

@Service
// @RequiredArgsConstructor
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public static final String deleteCategory = null;

    public ResponseEntity<?> createCategory(CategoryModel categoryModel) {
        categoryModel.setCategoryName(categoryModel.getCategoryName().toLowerCase());

        if (this.existByName(categoryModel)) {
            return ResponseEntity.badRequest().body("category already exist");
        }
        return this.categoryMapper.createCategory(categoryModel)
                ? new ResponseEntity<String>("created", HttpStatus.CREATED)
                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getCategory(Integer id) {
        return ResponseEntity.ok().body(this.categoryMapper.getCategory(id));
    }

    public List<Object> getAllCategory() {
        return this.categoryMapper.getAllCategory();
    }

    public ResponseEntity<?> updateCategory(CategoryModel categoryModel) {
        if (this.existByName(categoryModel)) {
            return ResponseEntity.badRequest().body("category already exist");
        }
        return this.categoryMapper.updateCategory(categoryModel)
                ? new ResponseEntity<String>("updated", HttpStatus.CREATED)
                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> deleteCategory(Integer id) {
        return this.categoryMapper.deleteCategory(id)
                ? new ResponseEntity<String>("deleted", HttpStatus.CREATED)
                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    private boolean existByName(CategoryModel categoryModel) {
        return this.categoryMapper.existsByName(categoryModel);
    }

}
