package com.bonigraphy.boni_api.menu.internal.repository;

import com.bonigraphy.boni_api.menu.internal.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

}
