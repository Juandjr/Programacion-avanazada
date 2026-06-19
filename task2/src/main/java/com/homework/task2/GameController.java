package com.homework.task2;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public Mono<Game> createGame(@RequestBody Game game) {
        return gameService.saveGame(game);
    }

    // Endpoint reactivo nativo usando Server-Sent Events (SSE)
    // Esto demuestra el modelo Publisher-Subscriber en el navegador/cliente
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Game> streamGames() {
        return gameService.getLiveGameStream();
    }
}
