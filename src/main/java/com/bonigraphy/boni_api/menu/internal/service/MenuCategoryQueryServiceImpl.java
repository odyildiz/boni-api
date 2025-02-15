package com.bonigraphy.boni_api.menu.internal.service;

import com.bonigraphy.boni_api.menu.internal.MenuCategoryDto;
import com.bonigraphy.boni_api.menu.internal.MenuCategoryQueryPort;
import com.bonigraphy.boni_api.menu.internal.repository.MenuCategoryRepository;
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
