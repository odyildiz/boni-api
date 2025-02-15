package com.bonigraphy.boni_api.ui;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuContent {

    private List<MenuCategory> menuCategories;

    @Setter
    @Getter
    @AllArgsConstructor
    public static class MenuCategory {
        private Long id;
        private String slug;
        private Name name;
        private List<MenuItem> menuItems;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class MenuItem {
        private Long id;
        private Long categoryId;
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
        private Double price1;
        private Double price2;
    }
}

