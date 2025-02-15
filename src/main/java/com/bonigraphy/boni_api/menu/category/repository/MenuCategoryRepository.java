package com.bonigraphy.boni_api.menu.category.repository;

import com.bonigraphy.boni_api.menu.category.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

}
