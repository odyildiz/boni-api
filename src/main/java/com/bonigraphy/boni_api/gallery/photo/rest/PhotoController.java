package com.bonigraphy.boni_api.gallery.photo.rest;

import com.bonigraphy.boni_api.gallery.GalleryPhotoDto;
import com.bonigraphy.boni_api.gallery.photo.dto.AddPhotoRequest;
import com.bonigraphy.boni_api.gallery.photo.dto.UpdatePhotoRequest;
import com.bonigraphy.boni_api.gallery.photo.service.PhotoCommandService;
import com.bonigraphy.boni_api.gallery.photo.service.PhotoQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gallery/photo")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoCommandService photoCommandService;
    private final PhotoQueryService photoQueryService;

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<GalleryPhotoDto>> list() {
        return ResponseEntity.ok(photoQueryService.findAll());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HttpStatus> create(@RequestBody AddPhotoRequest addPhotoRequest) {
        photoCommandService.create(addPhotoRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HttpStatus> update(@PathVariable Long id, @RequestBody UpdatePhotoRequest updatePhotoRequest) {
        photoCommandService.update(id, updatePhotoRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        photoCommandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}