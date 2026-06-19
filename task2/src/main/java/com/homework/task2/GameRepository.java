package com.homework.task2;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends ReactiveCrudRepository<Game, Long> {
}
