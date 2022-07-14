package com.dom.food.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dom.food.category.models.CategoryModel;

@Mapper
public interface CategoryMapper {

    boolean createCategory(CategoryModel category);

    CategoryModel getCategory(Integer id);

    List<CategoryModel> getAllCategory();

    boolean updateCategory(CategoryModel category);

    boolean deleteCategory(Integer id);

    boolean existsByName(CategoryModel category);

}
