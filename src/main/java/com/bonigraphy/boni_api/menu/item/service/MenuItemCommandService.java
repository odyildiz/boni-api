package com.bonigraphy.boni_api.menu.item.service;

import com.bonigraphy.boni_api.menu.item.dto.AddMenuItemRequest;
import com.bonigraphy.boni_api.menu.item.dto.UpdateMenuItemRequest;

import java.util.List;

public interface MenuItemCommandService {
    void create(Long categoryId, AddMenuItemRequest addMenuItemRequest);
    void update(Long id, UpdateMenuItemRequest updateMenuItemRequest);
    void delete(Long id);
    void updateSortOrder(List<Long> orderedIds, Long categoryId);
}