package com.bonigraphy.boni_api.menu.item.service;

import com.bonigraphy.boni_api.menu.category.repository.MenuCategoryRepository;
import com.bonigraphy.boni_api.menu.item.dto.AddMenuItemRequest;
import com.bonigraphy.boni_api.menu.item.dto.UpdateMenuItemRequest;
import com.bonigraphy.boni_api.menu.item.entity.MenuItem;
import com.bonigraphy.boni_api.menu.item.repository.MenuItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuItemCommandServiceImpl implements MenuItemCommandService {

    private final MenuItemRepository menuItemRepository;
    private final MenuCategoryRepository menuCategoryRepository;

    @Override
    public void create(AddMenuItemRequest addMenuItemRequest) {
        var slug = slugify(addMenuItemRequest.getNameEn());

        if (menuItemRepository.existsBySlug(slug)) {
            throw new IllegalArgumentException("Bu menü elemanı zaten bulunmakta: " + slug);
        }

        var category = menuCategoryRepository.findById(addMenuItemRequest.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Menü kategorisi bulunamadı: " + addMenuItemRequest.getCategoryId()));

        var menuItem = MenuItem.builder()
                .slug(slugify(slug))
                .nameTr(addMenuItemRequest.getNameTr())
                .nameEn(addMenuItemRequest.getNameEn())
                .price1(addMenuItemRequest.getPrice1())
                .price2(addMenuItemRequest.getPrice2())
                .category(category)
                .build();

        menuItemRepository.save(menuItem);
    }

    @Override
    public void update(Long id, UpdateMenuItemRequest updateMenuItemRequest) {

        var menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Menü elemanı bulunamadı: " + id));

        menuItem.setSlug(slugify(updateMenuItemRequest.getNameEn()));
        menuItem.setNameTr(updateMenuItemRequest.getNameTr());
        menuItem.setNameEn(updateMenuItemRequest.getNameEn());
        menuItem.setPrice1(updateMenuItemRequest.getPrice1());
        menuItem.setPrice2(updateMenuItemRequest.getPrice2());

        menuItemRepository.save(menuItem);
    }

    @Override
    public void delete(Long id) {
        menuItemRepository.deleteById(id);
    }

    private static String slugify(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        return input.toLowerCase()
                .replaceAll("[^a-z0-9\\s-]", " ")
                .trim()
                .replaceAll("\\s+", "-")
                .replaceAll("-+", "-");
    }
}