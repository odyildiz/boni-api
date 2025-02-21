package com.bonigraphy.boni_api.menu.category.repository;

import com.bonigraphy.boni_api.menu.category.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {

    @Query("SELECT COALESCE(MAX(i.sortOrder), 0) + 1 FROM MenuCategory i")
    int getNextSortOrder();

    @Query(value = """
    SELECT * FROM menu_category
    WHERE id = ANY(CAST(:ids AS bigint[]))
    ORDER BY array_position(CAST(:ids AS bigint[]), id)
""", nativeQuery = true)
    List<MenuCategory> findAllByIdInOrder(@Param("ids") Long[] ids);
}
