package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.photo.dto.AddPhotoRequest;
import com.bonigraphy.boni_api.gallery.photo.dto.UpdatePhotoRequest;
import com.bonigraphy.boni_api.gallery.photo.entity.Photo;
import com.bonigraphy.boni_api.gallery.photo.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoCommandServiceImpl implements PhotoCommandService {

    private final PhotoRepository photoRepository;

    public void create(AddPhotoRequest request) {
        int nextSortOrder = photoRepository.getNextSortOrder();
        var photo = Photo.builder()
                .imageUrl(request.getImageUrl())
                .titleTr(request.getTitleTr())
                .titleEn(request.getTitleEn())
                .descriptionTr(request.getDescriptionTr())
                .descriptionEn(request.getDescriptionEn())
                .sortOrder(nextSortOrder)
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
