package com.github.iamhi.onpath.core;

import com.github.iamhi.onpath.core.dto.BudgetInputDTO;
import reactor.core.publisher.Mono;

public interface BudgetInputService {

    Mono<BudgetInputDTO> getBudgetForUser(String userCode);

    Mono<BudgetInputDTO> updateBudget(BudgetInputDTO budgetInputDTO);
}
