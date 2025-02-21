package com.bonigraphy.boni_api.gallery.photo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String titleTr;

    @Column(nullable = false)
    private String titleEn;

    @Column(nullable = false)
    private String descriptionTr;

    @Column(nullable = false)
    private String descriptionEn;

    @Column(nullable = false)
    private Integer sortOrder;
}