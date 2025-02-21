package com.bonigraphy.boni_api.menu.category.service;

import com.bonigraphy.boni_api.gallery.photo.entity.Photo;
import com.bonigraphy.boni_api.menu.category.dto.AddMenuCategoryRequest;
import com.bonigraphy.boni_api.menu.category.dto.UpdateMenuCategoryRequest;
import com.bonigraphy.boni_api.menu.category.entity.MenuCategory;
import com.bonigraphy.boni_api.menu.category.repository.MenuCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuCategoryCommandServiceImpl implements MenuCategoryCommandService {
    private final MenuCategoryRepository menuCategoryRepository;

    @Override
    public void save(AddMenuCategoryRequest addMenuCategoryRequest) {
        int nextSortOrder = menuCategoryRepository.getNextSortOrder();
        var menuCategory = new MenuCategory();

        menuCategory.setSlug(slugify(addMenuCategoryRequest.getNameEn()));
        menuCategory.setNameTr(addMenuCategoryRequest.getNameTr());
        menuCategory.setNameEn(addMenuCategoryRequest.getNameEn());
        menuCategory.setSortOrder(nextSortOrder);

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

    @Override
    public void deleteById(Long id) {
        menuCategoryRepository.deleteById(id);
    }

    @Override
    public void updateSortOrder(List<Long> orderedIds) {
        List<MenuCategory> items = menuCategoryRepository.findAllByIdInOrder(orderedIds);
        for (int i = 0; i < orderedIds.size(); i++) {
            items.get(i).setSortOrder(i);
        }
        menuCategoryRepository.saveAll(items);
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

