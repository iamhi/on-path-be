package com.github.iamhi.onpath.core.dto;

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
}
