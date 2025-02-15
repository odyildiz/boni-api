package com.bonigraphy.boni_api.menu.item.repository;

import com.bonigraphy.boni_api.menu.item.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    boolean existsBySlug(String slug);

    List<MenuItem> findAllByCategory_Id(Long categoryId);
}