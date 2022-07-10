package com.dom.food.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dom.food.category.models.CategoryModel;

@Mapper
public interface CategoryMapper {

    boolean createCategory(CategoryModel category);

    Object getCategory(Integer id);

    List<Object> getAllCategory();

    boolean updateCategory(CategoryModel category);

    boolean deleteCategory(Integer id);

    boolean existsByName(CategoryModel category);

}
