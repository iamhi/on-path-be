package com.github.iamhi.onpath.gateway.content;

import com.github.iamhi.onpath.core.ContentService;
import com.github.iamhi.onpath.core.dto.ContentDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record ContentHandler(ContentService contentService) {

    private static final String VIEW_NAME_QUERY_PARAM = "viewName";

    public static String USERCODE_HEADER = "usercode";

    Mono<ServerResponse> getContent(ServerRequest serverRequest) {
        String userCode = serverRequest.headers().firstHeader(USERCODE_HEADER);
        String viewName = serverRequest.queryParam(VIEW_NAME_QUERY_PARAM).orElse("");

        if (StringUtils.isBlank(userCode)) {
            return ServerResponse.badRequest().bodyValue("Missing usercode");
        }

        if (StringUtils.isBlank(viewName)) {
            return ServerResponse.badRequest().bodyValue("Bad viewName");
        }

        return ServerResponse.ok().body(contentService.getContent(viewName, userCode), ContentDTO.class);
    }
}
