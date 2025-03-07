package com.bonigraphy.boni_api.ui;

import com.bonigraphy.boni_api.gallery.PhotoLabelQueryPort;
import com.bonigraphy.boni_api.gallery.PhotoQueryPort;
import com.bonigraphy.boni_api.gallery.GalleryPhotoLabelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/ui/gallery")
@RequiredArgsConstructor
public class GalleryContoller {

    private final PhotoQueryPort photoQueryPort;

    private final PhotoLabelQueryPort photoLabelQueryPort;

    @GetMapping("/list")
    public ResponseEntity<GalleryPhotoContent> list() {
        var galleryPhotos = photoQueryPort.findAll()
                .stream()
                .map(galleryPhotoDto ->
                        new GalleryPhotoContent.Photo(galleryPhotoDto.getId(), galleryPhotoDto.getImageUrl(), new GalleryPhotoContent.LocalizedContent(galleryPhotoDto.getTitleTr(), galleryPhotoDto.getTitleEn()), new GalleryPhotoContent.LocalizedContent(galleryPhotoDto.getDescriptionTr(), galleryPhotoDto.getDescriptionEn()), galleryPhotoDto.getLabels().stream().map(GalleryPhotoLabelDto::getId).collect(Collectors.toSet()))
                ).toList();
        return ResponseEntity.ok(new GalleryPhotoContent(galleryPhotos));
    }

    @GetMapping("/label/list")
    public ResponseEntity<GalleryPhotoLabelContent> labelList() {
        var galleryPhotoLabels = photoLabelQueryPort.findAll()
                .stream()
                .map(galleryPhotoLabelDto ->
                        new GalleryPhotoLabelContent.Label(galleryPhotoLabelDto.getId(), galleryPhotoLabelDto.getNameTr(), galleryPhotoLabelDto.getNameEn())
                ).toList();
        return ResponseEntity.ok(new GalleryPhotoLabelContent(galleryPhotoLabels));
    }

}
