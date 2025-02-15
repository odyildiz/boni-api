package com.bonigraphy.boni_api.menu;

import com.bonigraphy.boni_api.menu.category.entity.MenuCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCategoryDto {

    private Long id;
    private String slug;
    private String nameTr;
    private String nameEn;

    public MenuCategoryDto(MenuCategory menuCategory) {
        this.id = menuCategory.getId();
        this.slug = menuCategory.getSlug();
        this.nameTr = menuCategory.getNameTr();
        this.nameEn = menuCategory.getNameEn();
    }
}
