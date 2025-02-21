package com.bonigraphy.boni_api.menu.category.entity;

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
@Table(name = "menu_category")
public class MenuCategory {

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
    private Integer sortOrder;
}
