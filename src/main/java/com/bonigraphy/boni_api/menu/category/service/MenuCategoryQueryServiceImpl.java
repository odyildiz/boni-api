package com.bonigraphy.boni_api.menu.category.service;

import com.bonigraphy.boni_api.gallery.photo.entity.Photo;
import com.bonigraphy.boni_api.menu.category.entity.MenuCategory;
import com.bonigraphy.boni_api.menu.category.repository.MenuCategoryRepository;
import com.bonigraphy.boni_api.menu.MenuCategoryDto;
import com.bonigraphy.boni_api.menu.MenuCategoryQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuCategoryQueryServiceImpl implements MenuCategoryQueryService, MenuCategoryQueryPort {

    private final MenuCategoryRepository menuCategoryRepository;

    @Override
    public List<MenuCategoryDto> findAll() {
        return menuCategoryRepository.findAll().stream().sorted(Comparator.comparingInt(MenuCategory::getSortOrder)).map(MenuCategoryDto::new).toList();
    }

}
