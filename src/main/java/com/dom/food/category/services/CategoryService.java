package com.dom.food.category.services;

import com.dom.food.category.mapper.CategoryMapper;
import com.dom.food.category.models.CategoryModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



// import lombok.RequiredArgsConstructor;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public static final String deleteCategory = null;

    public CategoryModel createCategory(CategoryModel categoryModel) {
        categoryModel.setCategoryName(categoryModel.getCategoryName().toLowerCase());

//        if (this.existByName(categoryModel)) {
//            return ResponseEntity.badRequest().body("category already exist");
//        }
        return this.categoryMapper.createCategory(categoryModel) ? categoryModel : null;
//                ? new ResponseEntity<String>("created", HttpStatus.CREATED)
//                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public CategoryModel getCategory(Integer id) {
        return this.categoryMapper.getCategory(id);
    }

    public List<CategoryModel> getAllCategory() {
        return this.categoryMapper.getAllCategory();
    }

    public CategoryModel updateCategory(CategoryModel categoryModel) {
//        if (this.existByName(categoryModel)) {
//            return ResponseEntity.badRequest().body("category already exist");
//        }
        return this.categoryMapper.updateCategory(categoryModel) ? categoryModel : null;
//                ? new ResponseEntity<String>("updated", HttpStatus.CREATED)
//                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public boolean deleteCategory(Integer id) {
        return this.categoryMapper.deleteCategory(id);
//                ? new ResponseEntity<String>("deleted", HttpStatus.CREATED)
//                : new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
    }

    public boolean existByName(CategoryModel categoryModel) {
        return this.categoryMapper.existsByName(categoryModel);
    }

}
