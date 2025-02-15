package com.bonigraphy.boni_api.menu.internal.service;

import com.bonigraphy.boni_api.menu.internal.dto.AddMenuCategoryRequest;
import com.bonigraphy.boni_api.menu.internal.entity.MenuCategory;
import com.bonigraphy.boni_api.menu.internal.repository.MenuCategoryRepository;
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

