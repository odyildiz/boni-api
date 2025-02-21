package com.bonigraphy.boni_api.menu.item.entity;

import com.bonigraphy.boni_api.menu.category.entity.MenuCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu_item")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false, name = "name_tr")
    private String nameTr;

    @Column(nullable = false, name = "name_en")
    private String nameEn;

    @Column(nullable = false)
    private Double price1;

    @Column
    private Double price2;

    @Column(nullable = false)
    private Integer sortOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private MenuCategory category;
}