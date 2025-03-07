package com.bonigraphy.boni_api.gallery.photo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
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

    private String titleTr;

    private String titleEn;

    private String descriptionTr;

    private String descriptionEn;

    @Column(nullable = false)
    private Integer sortOrder;

    @ManyToMany
    @JoinTable(
            name = "photo_photo_label",
            joinColumns = @JoinColumn(name = "photo_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<PhotoLabel> photoLabels;
}