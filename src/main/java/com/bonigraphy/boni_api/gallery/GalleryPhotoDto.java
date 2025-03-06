package com.bonigraphy.boni_api.gallery;

import com.bonigraphy.boni_api.gallery.photo.dto.PhotoLabelDto;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class GalleryPhotoDto {

    private Long id;
    private String imageUrl;
    private String titleTr;
    private String titleEn;
    private String descriptionTr;
    private String descriptionEn;
    private Set<PhotoLabelDto> labels;

}
