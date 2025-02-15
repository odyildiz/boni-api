package com.bonigraphy.boni_api.menu.category.service;

import com.bonigraphy.boni_api.menu.category.repository.MenuCategoryRepository;
import com.bonigraphy.boni_api.menu.MenuCategoryDto;
import com.bonigraphy.boni_api.menu.MenuCategoryQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuCategoryQueryServiceImpl implements MenuCategoryQueryService, MenuCategoryQueryPort {

    private final MenuCategoryRepository menuCategoryRepository;

    @Override
    public List<MenuCategoryDto> findAll() {
        return menuCategoryRepository.findAll().stream().map(MenuCategoryDto::new).toList();
    }

}
