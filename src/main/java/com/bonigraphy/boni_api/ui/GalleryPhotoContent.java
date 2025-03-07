package com.bonigraphy.boni_api.ui;

import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GalleryPhotoContent {

    private List<GalleryPhotoContent.Photo> photos;

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Photo {
        private Long id;
        private String url;
        private GalleryPhotoContent.LocalizedContent title;
        private GalleryPhotoContent.LocalizedContent description;
        private Set<Long> labelIds;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class LocalizedContent {
        private String tr;
        private String en;
    }

}
