package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.photo.dto.AddPhotoRequest;
import com.bonigraphy.boni_api.gallery.photo.dto.UpdatePhotoRequest;
import com.bonigraphy.boni_api.gallery.photo.entity.Photo;
import com.bonigraphy.boni_api.gallery.photo.entity.PhotoLabel;
import com.bonigraphy.boni_api.gallery.photo.repository.PhotoLabelRepository;
import com.bonigraphy.boni_api.gallery.photo.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PhotoCommandServiceImpl implements PhotoCommandService {

    private final PhotoRepository photoRepository;
    private final PhotoLabelRepository photoLabelRepository;

    public void create(AddPhotoRequest request) {
        int nextSortOrder = photoRepository.getNextSortOrder();
        
        // Fetch photo labels if labelIds are provided
        Set<PhotoLabel> photoLabels = new HashSet<>();
        if (request.getLabelIds() != null && !request.getLabelIds().isEmpty()) {
            photoLabels = new HashSet<>(photoLabelRepository.findAllById(request.getLabelIds()));
        }
        
        var photo = Photo.builder()
                .imageUrl(request.getImageUrl())
                .titleTr(request.getTitleTr())
                .titleEn(request.getTitleEn())
                .descriptionTr(request.getDescriptionTr())
                .descriptionEn(request.getDescriptionEn())
                .sortOrder(nextSortOrder)
                .photoLabels(photoLabels)
                .build();
        photoRepository.save(photo);
    }

    public void update(Long id, UpdatePhotoRequest request) {
        var photo = photoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Photo not found"));

        photo.setImageUrl(request.getImageUrl());
        photo.setTitleTr(request.getTitleTr());
        photo.setTitleEn(request.getTitleEn());
        photo.setDescriptionTr(request.getDescriptionTr());
        photo.setDescriptionEn(request.getDescriptionEn());
        
        // Update photo labels if labelIds are provided
        if (request.getLabelIds() != null) {
            Set<PhotoLabel> photoLabels = new HashSet<>();
            if (!request.getLabelIds().isEmpty()) {
                photoLabels = new HashSet<>(photoLabelRepository.findAllById(request.getLabelIds()));
            }
            photo.setPhotoLabels(photoLabels);
        }

        photoRepository.save(photo);
    }

    public void delete(Long id) {
        photoRepository.deleteById(id);
    }

    @Override
    public void updateSortOrder(List<Long> orderedIds) {
        List<Photo> items = photoRepository.findAllByIdInOrder(orderedIds.toArray(new Long[0]));
        for (int i = 0; i < orderedIds.size(); i++) {
            items.get(i).setSortOrder(i);
        }
        photoRepository.saveAll(items);
    }

}
