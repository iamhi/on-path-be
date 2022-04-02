package com.github.iamhi.onpath.core.dto;

import java.util.List;

public record ContentDTO(
    String viewName,
    String type,
    List<ContentItemDTO> items
) {
}
