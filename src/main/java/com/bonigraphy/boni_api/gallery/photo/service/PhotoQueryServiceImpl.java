package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.GalleryPhotoDto;
import com.bonigraphy.boni_api.gallery.GalleryQueryPort;
import com.bonigraphy.boni_api.gallery.photo.dto.PhotoLabelDto;
import com.bonigraphy.boni_api.gallery.photo.entity.Photo;
import com.bonigraphy.boni_api.gallery.photo.entity.PhotoLabel;
import com.bonigraphy.boni_api.gallery.photo.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
                        .labels(mapPhotoLabelsToDto(photo.getPhotoLabels()))
                        .build())
                .toList();
    }
    
    private Set<PhotoLabelDto> mapPhotoLabelsToDto(Set<PhotoLabel> photoLabels) {
        if (photoLabels == null || photoLabels.isEmpty()) {
            return new HashSet<>();
        }
        
        return photoLabels.stream()
                .map(label -> PhotoLabelDto.builder()
                        .id(label.getId())
                        .nameTr(label.getNameTr())
                        .nameEn(label.getNameEn())
                        .build())
                .collect(Collectors.toSet());
    }
}
