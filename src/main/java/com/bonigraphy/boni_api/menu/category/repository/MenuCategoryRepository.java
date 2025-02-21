package com.bonigraphy.boni_api.menu.category.repository;

import com.bonigraphy.boni_api.menu.category.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

    @Query("SELECT COALESCE(MAX(i.sortOrder), 0) + 1 FROM MenuCategory i")
    int getNextSortOrder();
}
