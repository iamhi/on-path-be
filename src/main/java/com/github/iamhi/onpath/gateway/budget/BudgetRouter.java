package com.github.iamhi.onpath.gateway.budget;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BudgetRouter {

    private static final String ROUTER_PREFIX = "/budget";

    @Bean
    public RouterFunction<ServerResponse> budgetRouterCompose(BudgetHandler budgetHandler) {
        return route(GET(ROUTER_PREFIX), budgetHandler::get)
            .andRoute(POST(ROUTER_PREFIX).and(accept(MediaType.APPLICATION_JSON)), budgetHandler::createOrUpdate);
    }
}
