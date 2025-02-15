package com.bonigraphy.boni_api.menu.category.service;

import com.bonigraphy.boni_api.menu.category.dto.AddMenuCategoryRequest;
import com.bonigraphy.boni_api.menu.category.dto.UpdateMenuCategoryRequest;
import com.bonigraphy.boni_api.menu.category.entity.MenuCategory;
import com.bonigraphy.boni_api.menu.category.repository.MenuCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuCategoryCommandServiceImpl implements MenuCategoryCommandService {
    private final MenuCategoryRepository menuCategoryRepository;

    @Override
    public void save(AddMenuCategoryRequest addMenuCategoryRequest) {
        var menuCategory = new MenuCategory();

        menuCategory.setSlug(slugify(addMenuCategoryRequest.getNameEn()));
        menuCategory.setNameTr(addMenuCategoryRequest.getNameTr());
        menuCategory.setNameEn(addMenuCategoryRequest.getNameEn());

        menuCategoryRepository.save(menuCategory);
    }

    @Override
    public void update(Long id, UpdateMenuCategoryRequest updateMenuCategoryRequest) {
        var menuCategory = menuCategoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Menü kategorisi bulunamadı: " + id));

        menuCategory.setSlug(slugify(updateMenuCategoryRequest.getNameEn()));
        menuCategory.setNameTr(updateMenuCategoryRequest.getNameTr());
        menuCategory.setNameEn(updateMenuCategoryRequest.getNameEn());

        menuCategoryRepository.save(menuCategory);
    }

    public void deleteById(Long id) {
        menuCategoryRepository.deleteById(id);
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

