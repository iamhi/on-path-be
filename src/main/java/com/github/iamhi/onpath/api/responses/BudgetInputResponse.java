package com.github.iamhi.onpath.api.responses;

public record BudgetInputResponse(
    Double income,
    Double stocks,
    Double crypto,
    Double debt,
    Double spending,
    Double savings
) {
}
