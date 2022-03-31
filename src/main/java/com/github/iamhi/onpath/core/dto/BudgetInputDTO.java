package com.github.iamhi.onpath.core.dto;

import com.github.iamhi.onpath.data.BudgetInputEntity;

public record BudgetInputDTO(
    String uuid,
    String userCode,
    Double income,
    Double stocks,
    Double crypto,
    Double debt,
    Double spending,
    Double savings
) {

    public static BudgetInputDTO fromEntity(BudgetInputEntity budgetInputEntity) {
        return new BudgetInputDTO(
            budgetInputEntity.uuid(),
            budgetInputEntity.userCode(),
            budgetInputEntity.income(),
            budgetInputEntity.stocks(),
            budgetInputEntity.crypto(),
            budgetInputEntity.debt(),
            budgetInputEntity.spending(),
            budgetInputEntity.savings()
        );
    }
}
