package com.bonigraphy.boni_api.ui;

import com.bonigraphy.boni_api.menu.internal.MenuCategoryQueryPort;
import com.bonigraphy.boni_api.menu.internal.MenuItemQueryPort;
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
    public ResponseEntity<MenuContent> list() throws IOException {
        var menuCategories = menuCategoryQueryPort.findAll().stream().map(menuCategoryDto -> new MenuContent.MenuCategory(menuCategoryDto.getId(), menuCategoryDto.getSlug(), new MenuContent.Name(menuCategoryDto.getNameTr(), menuCategoryDto.getNameEn()))).toList();
        return ResponseEntity.ok(new MenuContent(menuCategories, null));
    }

}
