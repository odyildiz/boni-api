package com.bonigraphy.boni_api.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class MenuContent {

    private List<MenuCategory> menuCategories;
    private List<MenuItem> menuItems;

    @Setter
    @Getter
    @AllArgsConstructor
    public static class MenuCategory {
        private Long id;
        private String slug;
        private Name name;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class MenuItem {
        private Long id;
        private String slug;
        private Name name;
        private Price price;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Name {
        private String tr;
        private String en;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Price {
        private String price1;
        private String price2;
    }
}
