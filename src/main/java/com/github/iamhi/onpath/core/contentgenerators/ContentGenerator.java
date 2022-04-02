package com.github.iamhi.onpath.core.contentgenerators;

import com.github.iamhi.onpath.core.dto.ContentDTO;
import reactor.core.publisher.Mono;

public interface ContentGenerator {

    String getViewName();

    String getType();

    Mono<ContentDTO> generate(String userCode);
}
