package com.github.iamhi.onpath.data;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BudgetInputRepository  extends ReactiveMongoRepository<BudgetInputEntity, String> {

    Mono<BudgetInputEntity> findByUserCode(String userCode);
}
