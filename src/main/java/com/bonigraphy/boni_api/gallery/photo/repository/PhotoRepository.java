package com.bonigraphy.boni_api.gallery.photo.repository;

import com.bonigraphy.boni_api.gallery.photo.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("SELECT COALESCE(MAX(i.sortOrder), 0) + 1 FROM Photo i")
    int getNextSortOrder();

}