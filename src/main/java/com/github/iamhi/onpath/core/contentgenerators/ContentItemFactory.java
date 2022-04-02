package com.github.iamhi.onpath.core.contentgenerators;

import com.github.iamhi.onpath.core.dto.ContentItemDTO;

public final class ContentItemFactory {
    private ContentItemFactory() {
    }

    public static ContentItemDTO createTextItem(String key, Object value) {
        return createItem(key, ContentItemDTO.TEXT_TYPE, value);
    }

    public static ContentItemDTO createSubtitleItem(String key, Object value) {
        return createItem(key, ContentItemDTO.SUBTITLE_TYPE, value);
    }

    public static ContentItemDTO createTitleItem(String key, Object value) {
        return createItem(key, ContentItemDTO.TITLE_TYPE, value);
    }

    public static ContentItemDTO createItem(String key, String type, Object value) {
        return new ContentItemDTO(
            key,
            type,
            String.valueOf(value)
        );
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj != null && obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "ContentItemFactory[]";
    }

}
