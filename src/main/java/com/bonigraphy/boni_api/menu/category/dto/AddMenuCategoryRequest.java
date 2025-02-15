package com.bonigraphy.boni_api.menu.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddMenuCategoryRequest {

    private String nameTr;
    private String nameEn;

}
