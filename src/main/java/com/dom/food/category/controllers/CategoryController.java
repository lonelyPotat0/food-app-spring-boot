package com.dom.food.category.controllers;

import com.dom.food.category.models.CategoryModel;
import com.dom.food.category.services.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



// import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    CategoryService categoryrService;

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryModel categoryModel) throws HttpResponseException {
        return  ResponseEntity.created(null).body(this.categoryrService.createCategory(categoryModel));
    }

    @GetMapping()
    public List<CategoryModel> getAllCategory() {
        return this.categoryrService.getAllCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> getCategory(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(this.categoryrService.getCategory(Integer.parseInt(id)));
    }

    @PutMapping()
    public ResponseEntity<?> updateCategory(@RequestBody CategoryModel categoryModel) throws HttpResponseException {
        return  ResponseEntity.ok().body(this.categoryrService.updateCategory(categoryModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") String id) throws HttpResponseException, NumberFormatException {
        return ResponseEntity.ok().body(this.categoryrService.deleteCategory(Integer.parseInt(id)));
    }
}
