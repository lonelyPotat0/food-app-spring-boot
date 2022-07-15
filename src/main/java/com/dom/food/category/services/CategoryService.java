package com.dom.food.category.services;

import com.dom.food.category.mapper.CategoryMapper;
import com.dom.food.category.models.CategoryModel;
import java.util.List;
import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




// import lombok.RequiredArgsConstructor;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public static final String deleteCategory = null;

    public CategoryModel createCategory(CategoryModel categoryModel) throws HttpResponseException {
        categoryModel.setCategoryName(categoryModel.getCategoryName().toLowerCase());

       if (this.existByName(categoryModel)) {
           throw new HttpResponseException(400, "category already exist");
        }
        if (this.categoryMapper.createCategory(categoryModel)) {
            return categoryModel;
        }
        throw new HttpResponseException(400, "fail");
    }

    public CategoryModel getCategory(Integer id) {
        return this.categoryMapper.getCategory(id);
    }

    public List<CategoryModel> getAllCategory() {
        return this.categoryMapper.getAllCategory();
    }

    public boolean deleteCategory(Integer id) throws HttpResponseException {
        if (this.categoryMapper.deleteCategory(id)) {
                return true;
        }
        throw new HttpResponseException(400, "fail");
    }

    public CategoryModel updateCategory(CategoryModel categoryModel) throws HttpResponseException {
       if (this.existByName(categoryModel)) {
           throw new HttpResponseException(400, "category already exist");
       }
        if (this.categoryMapper.updateCategory(categoryModel)) {
            return categoryModel;
        }
        throw new HttpResponseException(400, "fail");
    }

    

    private boolean existByName(CategoryModel categoryModel) {
        return this.categoryMapper.existsByName(categoryModel);
    }

}
