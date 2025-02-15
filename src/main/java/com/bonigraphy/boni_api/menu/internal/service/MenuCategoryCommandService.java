package com.bonigraphy.boni_api.menu.internal.service;

import com.bonigraphy.boni_api.menu.internal.dto.AddMenuCategoryRequest;

public interface MenuCategoryCommandService {

    void save(AddMenuCategoryRequest addMenuCategoryRequest);

    void deleteById(Long id);

}
