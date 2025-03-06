package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.photo.dto.AddPhotoLabelRequest;
import com.bonigraphy.boni_api.gallery.photo.dto.UpdatePhotoLabelRequest;

public interface PhotoLabelCommandService {

    void create(AddPhotoLabelRequest request);
    void update(Long id, UpdatePhotoLabelRequest request);
    void delete(Long id);
}