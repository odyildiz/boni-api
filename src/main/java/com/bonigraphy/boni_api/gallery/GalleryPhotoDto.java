package com.bonigraphy.boni_api.gallery;

import com.bonigraphy.boni_api.gallery.photo.entity.Photo;
import lombok.Builder;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Builder
public class GalleryPhotoDto {

    private Long id;
    private String imageUrl;
    private String titleTr;
    private String titleEn;
    private String descriptionTr;
    private String descriptionEn;
    private Set<GalleryPhotoLabelDto> labels;

    public static GalleryPhotoDto fromPhoto(Photo photo) {
        var photoLabels = new HashSet<>(photo.getPhotoLabels());
        return GalleryPhotoDto.builder()
                .id(photo.getId())
                .imageUrl(photo.getImageUrl())
                .titleTr(photo.getTitleTr())
                .titleEn(photo.getTitleEn())
                .descriptionTr(photo.getDescriptionTr())
                .descriptionEn(photo.getDescriptionEn())
                .labels(photoLabels.stream().map(GalleryPhotoLabelDto::fromPhotoLabel).collect(Collectors.toSet()))
                .build();
    }

}
