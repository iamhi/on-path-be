package com.github.iamhi.onpath.core.contentgenerators;

import com.github.iamhi.onpath.core.BudgetInputService;
import com.github.iamhi.onpath.core.dto.BudgetInputDTO;
import com.github.iamhi.onpath.core.dto.ContentDTO;
import com.github.iamhi.onpath.core.dto.ContentItemDTO;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public record BudgetReferenceView(
    BudgetInputService budgetInputService
) implements ContentGenerator {
    @Override
    public String getViewName() {
        return "ReferenceView";
    }

    @Override
    public String getType() {
        return "view";
    }

    @Override
    public Mono<ContentDTO> generate(String userCode) {
        return budgetInputService.getBudgetForUser(userCode).map(budgetInputDTO ->
            new ContentDTO(
                getViewName(),
                getType(),
                getItems(budgetInputDTO)
            ));
    }

    List<ContentItemDTO> getItems(BudgetInputDTO budgetInputDTO) {
        return List.of(
            ContentItemFactory.createSubtitleItem("budget-input-subtitle-1", "Desired budget allocation"),
            ContentItemFactory.createTextItem("budget-input-text-1", "Income: " + budgetInputDTO.income()),
            ContentItemFactory.createTextItem("budget-input-text-2", "Stocks: " + budgetInputDTO.stocks()),
            ContentItemFactory.createTextItem("budget-input-text-3", "Crypto: " + budgetInputDTO.crypto()),
            ContentItemFactory.createTextItem("budget-input-text-4", "Debt: " + budgetInputDTO.debt()),
            ContentItemFactory.createTextItem("budget-input-text-5", "Spending: " + budgetInputDTO.spending()),
            ContentItemFactory.createTextItem("budget-input-text-6", "Savings: " + budgetInputDTO.savings())
        );
    }
}
