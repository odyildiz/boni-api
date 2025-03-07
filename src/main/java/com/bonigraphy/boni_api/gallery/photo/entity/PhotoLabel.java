package com.bonigraphy.boni_api.gallery.photo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "photo_label")
public class PhotoLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameTr;

    @Column(nullable = false)
    private String nameEn;

    @ManyToMany(mappedBy = "photoLabels", fetch = FetchType.EAGER)
    private Set<Photo> photos;

}
