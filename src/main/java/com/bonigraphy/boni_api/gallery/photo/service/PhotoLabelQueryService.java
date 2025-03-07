package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.GalleryPhotoLabelDto;

import java.util.List;

public interface PhotoLabelQueryService {

    List<GalleryPhotoLabelDto> findAll();

}