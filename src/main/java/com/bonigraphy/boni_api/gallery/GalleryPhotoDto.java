package com.bonigraphy.boni_api.gallery;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GalleryPhotoDto {

    private Long id;
    private String imageUrl;
    private String titleTr;
    private String titleEn;
    private String descriptionTr;
    private String descriptionEn;

}
