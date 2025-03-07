package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.GalleryPhotoLabelDto;
import com.bonigraphy.boni_api.gallery.PhotoLabelQueryPort;
import com.bonigraphy.boni_api.gallery.photo.repository.PhotoLabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoLabelQueryServiceImpl implements PhotoLabelQueryService, PhotoLabelQueryPort {

    private final PhotoLabelRepository photoLabelRepository;

    @Override
    public List<GalleryPhotoLabelDto> findAll() {
        return photoLabelRepository.findAll().stream()
                .map(photoLabel -> GalleryPhotoLabelDto.builder()
                        .id(photoLabel.getId())
                        .nameTr(photoLabel.getNameTr())
                        .nameEn(photoLabel.getNameEn())
                        .build())
                .toList();
    }
}