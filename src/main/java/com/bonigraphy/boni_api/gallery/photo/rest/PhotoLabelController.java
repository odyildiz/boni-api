package com.bonigraphy.boni_api.gallery.photo.rest;

import com.bonigraphy.boni_api.gallery.GalleryPhotoLabelDto;
import com.bonigraphy.boni_api.gallery.photo.dto.AddPhotoLabelRequest;
import com.bonigraphy.boni_api.gallery.photo.dto.UpdatePhotoLabelRequest;
import com.bonigraphy.boni_api.gallery.photo.service.PhotoLabelCommandService;
import com.bonigraphy.boni_api.gallery.photo.service.PhotoLabelQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gallery/photo/label")
@RequiredArgsConstructor
public class PhotoLabelController {

    private final PhotoLabelCommandService photoLabelCommandService;
    private final PhotoLabelQueryService photoLabelQueryService;

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<GalleryPhotoLabelDto>> list() {
        return ResponseEntity.ok(photoLabelQueryService.findAll());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HttpStatus> create(@RequestBody AddPhotoLabelRequest addPhotoLabelRequest) {
        photoLabelCommandService.create(addPhotoLabelRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HttpStatus> update(@PathVariable Long id, @RequestBody UpdatePhotoLabelRequest updatePhotoLabelRequest) {
        photoLabelCommandService.update(id, updatePhotoLabelRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        photoLabelCommandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
