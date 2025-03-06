package com.bonigraphy.boni_api.gallery.photo.service;

import com.bonigraphy.boni_api.gallery.photo.dto.PhotoLabelDto;
import com.bonigraphy.boni_api.gallery.photo.entity.PhotoLabel;
import com.bonigraphy.boni_api.gallery.photo.repository.PhotoLabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoLabelQueryServiceImpl implements PhotoLabelQueryService {

    private final PhotoLabelRepository photoLabelRepository;

    @Override
    public List<PhotoLabelDto> findAll() {
        return photoLabelRepository.findAll().stream()
                .map(photoLabel -> PhotoLabelDto.builder()
                        .id(photoLabel.getId())
                        .nameTr(photoLabel.getNameTr())
                        .nameEn(photoLabel.getNameEn())
                        .build())
                .toList();
    }
}