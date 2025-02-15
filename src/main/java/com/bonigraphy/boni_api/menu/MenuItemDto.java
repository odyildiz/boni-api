package com.bonigraphy.boni_api.menu;

import com.bonigraphy.boni_api.menu.item.entity.MenuItem;
import lombok.Getter;

@Getter
public class MenuItemDto {

    private Long id;
    private Long categoryId;
    private String slug;
    private String nameTr;
    private String nameEn;
    private Double price1;
    private Double price2;

    public MenuItemDto(MenuItem menuItem) {
        this.id = menuItem.getId();
        this.categoryId = menuItem.getCategory().getId();
        this.slug = menuItem.getSlug();
        this.nameTr = menuItem.getNameTr();
        this.nameEn = menuItem.getNameEn();
        this.price1 = menuItem.getPrice1();
        this.price2 = menuItem.getPrice2();
    }

}
