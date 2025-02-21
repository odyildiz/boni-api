package com.bonigraphy.boni_api.menu.item.rest;

import com.bonigraphy.boni_api.menu.MenuItemDto;
import com.bonigraphy.boni_api.menu.item.dto.AddMenuItemRequest;
import com.bonigraphy.boni_api.menu.item.dto.UpdateMenuItemRequest;
import com.bonigraphy.boni_api.menu.item.service.MenuItemCommandService;
import com.bonigraphy.boni_api.menu.item.service.MenuItemQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu/item")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemCommandService menuItemCommandService;
    private final MenuItemQueryService menuItemQueryService;

    @GetMapping("/list/{categoryId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<MenuItemDto>> list(@PathVariable Long categoryId) {
        return ResponseEntity.ok(menuItemQueryService.findAllByCategoryId(categoryId));
    }

    @PostMapping("/add/{categoryId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HttpStatus> create(@RequestBody AddMenuItemRequest addMenuItemRequest, @PathVariable Long categoryId) {
        menuItemCommandService.create(categoryId, addMenuItemRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HttpStatus> update(@PathVariable Long id, @RequestBody UpdateMenuItemRequest updateMenuItemRequest) {
        menuItemCommandService.update(id, updateMenuItemRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        menuItemCommandService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reorder/{categoryId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HttpStatus> reorderItems(@RequestBody List<Long> orderedIds, @PathVariable Long categoryId) {
        menuItemCommandService.updateSortOrder(orderedIds, categoryId);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}