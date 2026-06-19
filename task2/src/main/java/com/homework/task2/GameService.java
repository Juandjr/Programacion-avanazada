package com.homework.task2;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Retorna un stream (Flux) de juegos simulando actualizaciones en tiempo real cada 1 segundo
    public Flux<Game> getLiveGameStream() {
        return gameRepository.findAll()
                .delayElements(Duration.ofSeconds(1)) // Simula flujo asíncrono
                .repeat(); // Mantiene el stream vivo para emular eventos constantes
    }

    public Mono<Game> saveGame(Game game) {
        return gameRepository.save(game);
    }
}
