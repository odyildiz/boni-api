package com.bonigraphy.boni_api.gallery.photo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SortOrderRequest {
    private List<Long> orderedIds;
}
