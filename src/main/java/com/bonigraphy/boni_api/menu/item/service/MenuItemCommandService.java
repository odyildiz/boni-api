package com.bonigraphy.boni_api.menu.item.service;

import com.bonigraphy.boni_api.menu.item.dto.AddMenuItemRequest;
import com.bonigraphy.boni_api.menu.item.dto.UpdateMenuItemRequest;

public interface MenuItemCommandService {
    void create(Long categoryId, AddMenuItemRequest addMenuItemRequest);
    void update(Long id, UpdateMenuItemRequest updateMenuItemRequest);
    void delete(Long id);
}