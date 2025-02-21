package com.bonigraphy.boni_api.menu.category.dto;

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
