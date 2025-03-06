package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.photo.dto.PhotoLabelDto;

import java.util.List;

public interface PhotoLabelQueryService {

    List<PhotoLabelDto> findAll();

}