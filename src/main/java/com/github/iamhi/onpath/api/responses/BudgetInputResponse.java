package com.github.iamhi.onpath.api.responses;

public record BudgetInputResponse(
    String uuid,
    Double income,
    Double stocks,
    Double crypto,
    Double debt,
    Double spending,
    Double savings
) {
}
