package com.github.iamhi.onpath.api.requests;

public record BudgetInputRequest(
    String uuid,
    Double income,
    Double stocks,
    Double crypto,
    Double debt,
    Double spending,
    Double savings
) {
}
