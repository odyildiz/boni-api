package com.bonigraphy.boni_api.menu.category.rest;

import com.bonigraphy.boni_api.menu.category.dto.AddMenuCategoryRequest;
import com.bonigraphy.boni_api.menu.category.dto.UpdateMenuCategoryRequest;
import com.bonigraphy.boni_api.menu.category.service.MenuCategoryCommandService;
import com.bonigraphy.boni_api.menu.category.service.MenuCategoryQueryService;
import com.bonigraphy.boni_api.menu.MenuCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu/category")
@RequiredArgsConstructor
public class MenuCategoryController {

    private final MenuCategoryCommandService menuCategoryCommandService;

    private final MenuCategoryQueryService menuCategoryQueryService;

    @GetMapping("/list")
    @CrossOrigin
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<MenuCategoryDto>> list() {
        return ResponseEntity.ok(menuCategoryQueryService.findAll());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HttpStatus> add(@RequestBody AddMenuCategoryRequest addMenuCategoryRequest) {
        menuCategoryCommandService.save(addMenuCategoryRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HttpStatus> update(@PathVariable Long id, @RequestBody UpdateMenuCategoryRequest updateMenuCategoryRequest) {
        menuCategoryCommandService.update(id ,updateMenuCategoryRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        menuCategoryCommandService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
