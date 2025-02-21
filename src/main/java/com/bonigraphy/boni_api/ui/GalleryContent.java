package com.bonigraphy.boni_api.ui;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GalleryContent {

    private List<GalleryContent.Photo> photos;

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Photo {
        private Long id;
        private String url;
        private GalleryContent.LocalizedContent title;
        private GalleryContent.LocalizedContent description;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class LocalizedContent {
        private String tr;
        private String en;
    }

}
