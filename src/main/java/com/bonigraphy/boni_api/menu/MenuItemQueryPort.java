package com.bonigraphy.boni_api.menu;

import java.util.List;

public interface MenuItemQueryPort {

    List<MenuItemDto> findAllByCategoryId(Long categoryId);

}
