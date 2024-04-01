package com.example.snakeandleadergame;
import com.example.snakeandleadergame.entity.Point;
import com.example.snakeandleadergame.enumurator.MovementStrategy;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class Configuration {
  // Getters and setters
  @JsonProperty("players")
  private int players;

  @JsonProperty("board_size")
  private int boardSize;

  @JsonProperty("number_of_snakes")
  private int numberOfSnakes;

  @JsonProperty("number_of_ladders")
  private int numberOfLadders;
  @JsonProperty("number_of_crocodile")
  private int numberOfCrocodile;

  @JsonProperty("number_of_dice")
  private int numberOfDice;
  @JsonProperty("number_of_mine")
  private int numberOfMine;

  @JsonProperty("movement_strategy")
  private MovementStrategy movementStrategy;

  @JsonProperty("number_of_snakes_pos")
  private List<Point> numberOfSnakesPos;
  @JsonProperty("number_of_ladders_pos")
  private List<Point> numberOfLadderPos;

  @JsonProperty("number_of_mine_pos")
  private List<Point> numberOfMinePos;

  @JsonProperty("number_of_crocodile_pos")
  private List<Point> numberOfCrocodilePos;

  // Default constructor (required by Jackson)
  public Configuration() {
  }


  // toString method for printing the configuration
  @Override
  public String toString() {
    return "Configuration{" +
        "players=" + players +
        ", boardSize=" + boardSize +
        ", numberOfSnakes=" + numberOfSnakes +
        ", numberOfLadders=" + numberOfLadders +
        ", numberOfDice=" + numberOfDice +
        ", movementStrategy='" + movementStrategy + '\'' +
        ", numberOfSnakesPos=" + numberOfSnakesPos +
        ", numberOfLadderPos=" + numberOfLadderPos +
        '}';
  }
}
