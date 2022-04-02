package com.github.iamhi.onpath.core;

import com.github.iamhi.onpath.core.dto.ContentDTO;
import reactor.core.publisher.Mono;

public interface ContentService {

    Mono<ContentDTO> getContent(String viewName, String userCode);
}
