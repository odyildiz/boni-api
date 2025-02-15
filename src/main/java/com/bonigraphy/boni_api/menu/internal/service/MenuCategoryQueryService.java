package com.bonigraphy.boni_api.menu.internal.service;

import com.bonigraphy.boni_api.menu.internal.MenuCategoryDto;

import java.util.List;

public interface MenuCategoryQueryService {

    List<MenuCategoryDto> findAll();

}
