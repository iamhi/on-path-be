package com.github.iamhi.onpath.core.dto;

public record ContentItemDTO(
    String key,
    String type,
    String content
) {
    public static String TITLE_TYPE = "title";

    public static String SUBTITLE_TYPE = "subtitle";

    public static String TEXT_TYPE = "text";
}