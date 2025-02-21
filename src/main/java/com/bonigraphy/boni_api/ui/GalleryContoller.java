package com.bonigraphy.boni_api.ui;

import com.bonigraphy.boni_api.gallery.GalleryQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ui/gallery")
@RequiredArgsConstructor
public class GalleryContoller {

    private final GalleryQueryPort galleryQueryPort;

    @GetMapping("/list")
    public ResponseEntity<GalleryContent> list() {
        var galleryPhotos = galleryQueryPort.findAll()
                .stream()
                .map(galleryPhotoDto ->
                        new GalleryContent.Photo(galleryPhotoDto.getId(), galleryPhotoDto.getImageUrl(), new GalleryContent.LocalizedContent(galleryPhotoDto.getTitleTr(), galleryPhotoDto.getTitleEn()), new GalleryContent.LocalizedContent(galleryPhotoDto.getDescriptionTr(), galleryPhotoDto.getDescriptionEn()))
                ).toList();
        return ResponseEntity.ok(new GalleryContent(galleryPhotos));
    }

}
