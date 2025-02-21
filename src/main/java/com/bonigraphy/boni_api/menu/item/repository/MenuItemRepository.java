package com.bonigraphy.boni_api.menu.item.repository;

import com.bonigraphy.boni_api.gallery.photo.entity.Photo;
import com.bonigraphy.boni_api.menu.category.entity.MenuCategory;
import com.bonigraphy.boni_api.menu.item.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    boolean existsBySlug(String slug);

    List<MenuItem> findAllByCategory_Id(Long categoryId);

    @Query("SELECT COALESCE(MAX(i.sortOrder), 0) + 1 FROM MenuItem i WHERE i.category.id = :categoryId")
    int getNextSortOrder(@Param("categoryId") Long categoryId);

    @Query(value = """
    SELECT * FROM menu_item
    WHERE id = ANY(CAST(:ids AS bigint[])) and category_id = :categoryId
    ORDER BY array_position(CAST(:ids AS bigint[]), id)
""", nativeQuery = true)
    List<MenuItem> findAllByIdInOrder(@Param("ids") Long[] ids, @Param("categoryId") Long categoryId);
}