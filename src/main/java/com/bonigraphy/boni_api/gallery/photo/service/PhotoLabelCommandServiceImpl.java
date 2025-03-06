package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.photo.dto.AddPhotoLabelRequest;
import com.bonigraphy.boni_api.gallery.photo.dto.UpdatePhotoLabelRequest;
import com.bonigraphy.boni_api.gallery.photo.entity.PhotoLabel;
import com.bonigraphy.boni_api.gallery.photo.repository.PhotoLabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoLabelCommandServiceImpl implements PhotoLabelCommandService {

    private final PhotoLabelRepository photoLabelRepository;

    @Override
    public void create(AddPhotoLabelRequest request) {
        var photoLabel = new PhotoLabel();
        photoLabel.setNameTr(request.getNameTr());
        photoLabel.setNameEn(request.getNameEn());
        
        photoLabelRepository.save(photoLabel);
    }

    @Override
    public void update(Long id, UpdatePhotoLabelRequest request) {
        var photoLabel = photoLabelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Photo label not found"));

        photoLabel.setNameTr(request.getNameTr());
        photoLabel.setNameEn(request.getNameEn());

        photoLabelRepository.save(photoLabel);
    }

    @Override
    public void delete(Long id) {
        photoLabelRepository.deleteById(id);
    }
}