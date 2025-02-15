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

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<MenuItemDto>> list() {
        return ResponseEntity.ok(menuItemQueryService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<MenuItemDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(menuItemQueryService.findById(id));
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> create(@RequestBody AddMenuItemRequest addMenuItemRequest) {
        menuItemCommandService.create(addMenuItemRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> update(@PathVariable Long id, @RequestBody UpdateMenuItemRequest updateMenuItemRequest) {
        menuItemCommandService.update(id, updateMenuItemRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        menuItemCommandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}