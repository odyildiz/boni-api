package com.bonigraphy.boni_api.ui;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GalleryPhotoLabelContent {

    private List<Label> labels;

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Label {
        private Long id;
        private String nameTr;
        private String nameEn;
    }

}
