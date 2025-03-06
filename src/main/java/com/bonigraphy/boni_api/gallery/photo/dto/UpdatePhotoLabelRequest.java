package com.bonigraphy.boni_api.gallery.photo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePhotoLabelRequest {
    
    private String nameTr;
    private String nameEn;
}