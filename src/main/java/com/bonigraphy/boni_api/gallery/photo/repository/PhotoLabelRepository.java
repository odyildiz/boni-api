package com.bonigraphy.boni_api.gallery.photo.repository;

import com.bonigraphy.boni_api.gallery.photo.entity.PhotoLabel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoLabelRepository extends JpaRepository<PhotoLabel, Long> {
}
