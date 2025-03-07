package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.GalleryPhotoDto;
import com.bonigraphy.boni_api.gallery.PhotoQueryPort;
import com.bonigraphy.boni_api.gallery.photo.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PhotoQueryServiceImpl implements PhotoQueryService, PhotoQueryPort {

    private final PhotoRepository photoRepository;

    public List<GalleryPhotoDto> findAll() {
        var photos = new ArrayList<>(photoRepository.findAllByOrderBySortOrderAsc());
        return photos.stream()
                .map(GalleryPhotoDto::fromPhoto)
                .toList();
    }

}
