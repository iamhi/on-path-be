package com.github.iamhi.onpath.core;

import com.github.iamhi.onpath.core.dto.BudgetInputDTO;
import com.github.iamhi.onpath.data.BudgetInputEntity;
import com.github.iamhi.onpath.data.BudgetInputRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@Service
public record BudgetInputServiceImpl(
    BudgetInputRepository budgetInputRepository
) implements BudgetInputService {
    @Override
    public Mono<BudgetInputDTO> getBudgetForUser(String userCode) {
        return budgetInputRepository.findByUserCode(userCode)
            .switchIfEmpty(Mono.just(this.createBudgetInputEntity(userCode)).flatMap(budgetInputRepository::save))
            .map(BudgetInputDTO::fromEntity);
    }

    @Override
    public Mono<BudgetInputDTO> updateBudget(BudgetInputDTO budgetInputDTO) {
        if (StringUtils.isBlank(budgetInputDTO.userCode())) {
            return Mono.error(new RuntimeException());
        }

        return budgetInputRepository.findByUserCode(budgetInputDTO.userCode())
            .map(budgetInputEntity -> updateBudgetInputEntity(budgetInputEntity, budgetInputDTO))
            .flatMap(budgetInputRepository::save)
            .map(BudgetInputDTO::fromEntity);
    }

    private BudgetInputEntity createBudgetInputEntity(String userCode) {
        return new BudgetInputEntity(
            UUID.randomUUID().toString(),
            userCode,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0
        );
    }

    private BudgetInputEntity updateBudgetInputEntity(BudgetInputEntity oldEntity, BudgetInputDTO newData) {
        return new BudgetInputEntity(
            oldEntity.uuid(),
            oldEntity.userCode(),
            Objects.requireNonNullElse(newData.income(), oldEntity.income()),
            Objects.requireNonNullElse(newData.stocks(), oldEntity.stocks()),
            Objects.requireNonNullElse(newData.crypto(), oldEntity.crypto()),
            Objects.requireNonNullElse(newData.debt(), oldEntity.debt()),
            Objects.requireNonNullElse(newData.spending(), oldEntity.spending()),
            Objects.requireNonNullElse(newData.savings(), oldEntity.savings())
        );
    }
}
