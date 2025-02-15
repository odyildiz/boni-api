package com.bonigraphy.boni_api.ui;

import com.bonigraphy.boni_api.menu.MenuCategoryQueryPort;
import com.bonigraphy.boni_api.menu.MenuItemQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/ui/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuCategoryQueryPort menuCategoryQueryPort;

    private final MenuItemQueryPort menuItemQueryPort;

    @GetMapping("/list")
    public ResponseEntity<MenuContent> list() {
        var menuCategories = menuCategoryQueryPort.findAll()
                .stream()
                .map(menuCategoryDto ->
                        new MenuContent.MenuCategory(menuCategoryDto.getId(),
                                menuCategoryDto.getSlug(),
                                new MenuContent.Name(menuCategoryDto.getNameTr(), menuCategoryDto.getNameEn()),
                                menuItemQueryPort.findAllByCategoryId(menuCategoryDto.getId()).stream().map(menuItemDto -> new MenuContent.MenuItem(menuItemDto.getId(), menuItemDto.getCategoryId(), menuItemDto.getSlug(), new MenuContent.Name(menuItemDto.getNameTr(), menuItemDto.getNameEn()), new MenuContent.Price(menuItemDto.getPrice1(), menuItemDto.getPrice2()))).toList()
                        )).toList();
        return ResponseEntity.ok(new MenuContent(menuCategories));
    }

}
