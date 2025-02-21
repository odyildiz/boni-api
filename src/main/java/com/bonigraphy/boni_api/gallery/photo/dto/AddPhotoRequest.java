package com.bonigraphy.boni_api.gallery.photo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddPhotoRequest {
    
    private String imageUrl;
    private String titleTr;
    private String titleEn;
    private String descriptionTr;
    private String descriptionEn;
    
}