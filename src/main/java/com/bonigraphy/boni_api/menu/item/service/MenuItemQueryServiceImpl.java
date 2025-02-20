package com.bonigraphy.boni_api.menu.item.service;

import com.bonigraphy.boni_api.menu.MenuItemDto;
import com.bonigraphy.boni_api.menu.MenuItemQueryPort;
import com.bonigraphy.boni_api.menu.item.repository.MenuItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemQueryServiceImpl implements MenuItemQueryService, MenuItemQueryPort {

    private final MenuItemRepository menuItemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MenuItemDto> findAllByCategoryId(Long categoryId) {
        return menuItemRepository.findAllByCategory_Id(categoryId).stream()
                .map(MenuItemDto::new)
                .toList();
    }
}
