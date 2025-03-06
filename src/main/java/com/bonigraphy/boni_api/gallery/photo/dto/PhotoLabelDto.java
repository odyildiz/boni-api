package com.bonigraphy.boni_api.gallery.photo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PhotoLabelDto {

    private Long id;
    private String nameTr;
    private String nameEn;

}