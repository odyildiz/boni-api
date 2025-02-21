package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.photo.dto.AddPhotoRequest;
import com.bonigraphy.boni_api.gallery.photo.dto.UpdatePhotoRequest;

public interface PhotoCommandService {

    void create(AddPhotoRequest request);
    void update(Long id, UpdatePhotoRequest request);
    void delete(Long id);

}