package com.bonigraphy.boni_api.gallery.photo.dto;

import com.bonigraphy.boni_api.gallery.photo.entity.PhotoLabel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PhotoLabelDto {

    private Long id;
    private String nameTr;
    private String nameEn;

    public static PhotoLabelDto fromPhotoLabel(PhotoLabel photoLabel) {
        return PhotoLabelDto.builder()
                .id(photoLabel.getId())
                .nameTr(photoLabel.getNameTr())
                .nameEn(photoLabel.getNameEn())
                .build();
    }
}