package com.bonigraphy.boni_api.gallery;

import java.util.List;

public interface PhotoQueryPort {

    List<GalleryPhotoDto> findAll();

}
