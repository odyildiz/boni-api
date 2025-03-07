package com.bonigraphy.boni_api.gallery;

import com.bonigraphy.boni_api.gallery.photo.entity.PhotoLabel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GalleryPhotoLabelDto {

    private Long id;
    private String nameTr;
    private String nameEn;

    public static GalleryPhotoLabelDto fromPhotoLabel(PhotoLabel photoLabel) {
        return GalleryPhotoLabelDto.builder()
                .id(photoLabel.getId())
                .nameTr(photoLabel.getNameTr())
                .nameEn(photoLabel.getNameEn())
                .build();
    }
}