package com.homework.task2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner init(GameRepository repository, DatabaseClient client) {
        return args -> {
            // Creamos la tabla con nombres en mayúsculas idénticos al mapeo de Spring
            client.sql("CREATE TABLE IF NOT EXISTS GAMES (ID BIGINT AUTO_INCREMENT PRIMARY KEY, TITLE VARCHAR(255), PRICE DOUBLE, STOCK INT);")
                    .fetch()
                    .rowsUpdated()
                    .then(repository.deleteAll())
                    .thenMany(Flux.just(
                            new Game(null, "Elden Ring", 59.99, 100),
                            new Game(null, "Cyberpunk 2077", 39.99, 50),
                            new Game(null, "Hades II", 29.99, 200)
                    ))
                    .flatMap(repository::save)
                    .subscribe(
                            game -> System.out.println("Inserted: " + game.getTitle()),
                            error -> {
                                System.err.println("Error initializing data: " + error.getMessage());
                                error.printStackTrace();
                            }
                    );
        };
    }
}
