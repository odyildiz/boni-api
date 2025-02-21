package com.bonigraphy.boni_api.gallery.photo.repository;

import com.bonigraphy.boni_api.gallery.photo.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("SELECT COALESCE(MAX(i.sortOrder), 0) + 1 FROM Photo i")
    int getNextSortOrder();

    @Query(value = """
    SELECT * FROM photo
    WHERE id IN (:ids)
    ORDER BY array_position(ARRAY[:ids]::bigint[], id)
""", nativeQuery = true)
    List<Photo> findAllByIdInOrder(@Param("ids") List<Long> ids);

}