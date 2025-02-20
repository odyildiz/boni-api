package com.bonigraphy.boni_api.menu.item.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddMenuItemRequest {

    private String nameTr;
    private String nameEn;
    private Double price1;
    private Double price2;

}
