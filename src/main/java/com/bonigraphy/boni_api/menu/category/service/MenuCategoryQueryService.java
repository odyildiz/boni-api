package com.bonigraphy.boni_api.menu.category.service;

import com.bonigraphy.boni_api.menu.MenuCategoryDto;

import java.util.List;

public interface MenuCategoryQueryService {

    List<MenuCategoryDto> findAll();

}
