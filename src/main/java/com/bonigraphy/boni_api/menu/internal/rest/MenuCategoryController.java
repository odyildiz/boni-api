package com.bonigraphy.boni_api.menu.internal.rest;

import com.bonigraphy.boni_api.menu.internal.MenuCategoryDto;
import com.bonigraphy.boni_api.menu.internal.dto.AddMenuCategoryRequest;
import com.bonigraphy.boni_api.menu.internal.service.MenuCategoryCommandService;
import com.bonigraphy.boni_api.menu.internal.service.MenuCategoryQueryService;
import com.bonigraphy.boni_api.ui.MenuContent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/menu/category")
@RequiredArgsConstructor
public class MenuCategoryController {

    private final MenuCategoryCommandService menuCategoryCommandService;

    private final MenuCategoryQueryService menuCategoryQueryService;

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> add(AddMenuCategoryRequest request) {
        menuCategoryCommandService.save(request);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> delete(Long id) {
        menuCategoryCommandService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<MenuCategoryDto>> list() {
        return ResponseEntity.ok(menuCategoryQueryService.findAll());
    }

}
