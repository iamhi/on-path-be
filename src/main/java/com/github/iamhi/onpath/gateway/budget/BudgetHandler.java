package com.github.iamhi.onpath.gateway.budget;

import com.github.iamhi.onpath.api.requests.BudgetInputRequest;
import com.github.iamhi.onpath.api.responses.BudgetInputResponse;
import com.github.iamhi.onpath.core.BudgetInputService;
import com.github.iamhi.onpath.core.dto.BudgetInputDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record BudgetHandler(
    BudgetInputService budgetInputService
) {

    public static String USERCODE_HEADER = "usercode";

    Mono<ServerResponse> createOrUpdate(ServerRequest serverRequest) {
        String userCode = serverRequest.headers().firstHeader(USERCODE_HEADER);

        if (StringUtils.isBlank(userCode)) {
            return ServerResponse.badRequest().bodyValue("Missing usercode");
        }

        return serverRequest.bodyToMono(BudgetInputRequest.class)
            .map(budgetInputRequest -> createBudgetDTO(budgetInputRequest, userCode))
            .flatMap(budgetInputService::updateBudget)
            .map(this::createBudgetInputResponse)
            .flatMap(ServerResponse.ok()::bodyValue);
    }

    Mono<ServerResponse> get(ServerRequest serverRequest) {
        String userCode = serverRequest.headers().firstHeader(USERCODE_HEADER);

        if (StringUtils.isBlank(userCode)) {
            return ServerResponse.badRequest().bodyValue("Missing usercode");
        }

        return budgetInputService.getBudgetForUser(userCode)
            .map(this::createBudgetInputResponse)
            .flatMap(ServerResponse.ok()::bodyValue);
    }

    BudgetInputDTO createBudgetDTO(BudgetInputRequest budgetInputRequest, String userCode) {
        return new BudgetInputDTO(
            budgetInputRequest.uuid(),
            userCode,
            budgetInputRequest.income(),
            budgetInputRequest.stocks(),
            budgetInputRequest.crypto(),
            budgetInputRequest.debt(),
            budgetInputRequest.spending(),
            budgetInputRequest.savings()
        );
    }

    BudgetInputResponse createBudgetInputResponse(BudgetInputDTO budgetInputDTO) {
        return new BudgetInputResponse(
            budgetInputDTO.uuid(),
            budgetInputDTO.income(),
            budgetInputDTO.stocks(),
            budgetInputDTO.crypto(),
            budgetInputDTO.debt(),
            budgetInputDTO.spending(),
            budgetInputDTO.savings()
        );
    }
}
