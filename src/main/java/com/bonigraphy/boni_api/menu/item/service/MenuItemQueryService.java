package com.bonigraphy.boni_api.menu.item.service;

import com.bonigraphy.boni_api.menu.MenuItemDto;

import java.util.List;

public interface MenuItemQueryService {

    List<MenuItemDto> findAll();
    MenuItemDto findById(Long id);
    List<MenuItemDto> findAllByCategoryId(Long categoryId);
}
