package com.bonigraphy.boni_api.gallery.photo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "photo_label")
public class PhotoLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameTr;

    @Column(nullable = false)
    private String nameEn;

    @ManyToMany(mappedBy = "photoLabels")
    private Set<Photo> photos;

}
