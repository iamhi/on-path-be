package com.github.iamhi.onpath.gateway.content;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ContentRouter {

    private static final String ROUTER_PREFIX = "/content";

    @Bean
    public RouterFunction<ServerResponse> contentRouterCompose(ContentHandler contentHandler) {
        return route(GET(ROUTER_PREFIX), contentHandler::getContent);
    }
}
