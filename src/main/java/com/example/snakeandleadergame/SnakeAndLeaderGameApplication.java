package com.example.snakeandleadergame;

import com.example.snakeandleadergame.entity.Configuration;
import com.example.snakeandleadergame.enumurator.MovementStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;


@SpringBootApplication
public class SnakeAndLeaderGameApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SnakeAndLeaderGameApplication.class, args);

		ObjectMapper objectMapper = new ObjectMapper();
		File configFile = new File("config.json");

		// Read JSON file and map it to Configuration object
		Configuration configuration = objectMapper.readValue(configFile, Configuration.class);

		System.out.println("Configuration is "+ configuration.toString());
		Board board = new Board(configuration);
		GameService gameService = new GameService(board);
		System.out.println("Selected move strategy is "+ configuration.getMovementStrategy().getStrategy());
		gameService.play(MovementStrategy.MAX);

	}
}
