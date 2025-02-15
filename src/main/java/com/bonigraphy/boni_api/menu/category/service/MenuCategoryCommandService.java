package com.bonigraphy.boni_api.menu.category.service;

import com.bonigraphy.boni_api.menu.category.dto.AddMenuCategoryRequest;
import com.bonigraphy.boni_api.menu.category.dto.UpdateMenuCategoryRequest;

public interface MenuCategoryCommandService {

    void save(AddMenuCategoryRequest addMenuCategoryRequest);
    void update(Long id, UpdateMenuCategoryRequest updateMenuCategoryRequest);
    void deleteById(Long id);

}
