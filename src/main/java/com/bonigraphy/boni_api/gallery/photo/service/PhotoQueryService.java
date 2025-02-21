package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.GalleryPhotoDto;

import java.util.List;

public interface PhotoQueryService {

    List<GalleryPhotoDto> findAll();

}