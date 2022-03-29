package com.github.iamhi.onpath.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record BudgetInputEntity(

    @Id
    String uuid,

    @Indexed(name = "budget_input_usercode_index", unique = true)
    String userCode,

    Double income,

    Double stocks,

    Double crypto,

    Double debt,

    Double spending,

    Double savings
) {
}
