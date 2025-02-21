package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.GalleryPhotoDto;
import com.bonigraphy.boni_api.gallery.GalleryQueryPort;
import com.bonigraphy.boni_api.gallery.photo.entity.Photo;
import com.bonigraphy.boni_api.gallery.photo.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoQueryServiceImpl implements PhotoQueryService, GalleryQueryPort {

    private final PhotoRepository photoRepository;

    public List<GalleryPhotoDto> findAll() {
        return photoRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Photo::getSortOrder))
                .map(photo -> GalleryPhotoDto.builder()
                        .id(photo.getId())
                        .imageUrl(photo.getImageUrl())
                        .titleTr(photo.getTitleTr())
                        .titleEn(photo.getTitleEn())
                        .descriptionTr(photo.getDescriptionTr())
                        .descriptionEn(photo.getDescriptionEn())
                        .build())
                .toList();
    }
}
