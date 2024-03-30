package com.example.snakeandleadergame.entity;
import com.example.snakeandleadergame.entity.Point;
import com.example.snakeandleadergame.enumurator.MovementStrategy;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Configuration {
  @JsonProperty("players")
  private int players;

  @JsonProperty("board_size")
  private int boardSize;

  @JsonProperty("number_of_snakes")
  private int numberOfSnakes;

  @JsonProperty("number_of_ladders")
  private int numberOfLadders;

  @JsonProperty("number_of_dice")
  private int numberOfDice;

  @JsonProperty("movement_strategy")
  private MovementStrategy movementStrategy;

  @JsonProperty("number_of_snakes_pos")
  private List<Point> numberOfSnakesPos;
  @JsonProperty("number_of_ladders_pos")
  private List<Point> numberOfLadderPos;

  // Default constructor (required by Jackson)
  public Configuration() {
  }

  // Getters and setters
  public int getPlayers() {
    return players;
  }

  public void setPlayers(int players) {
    this.players = players;
  }

  public int getBoardSize() {
    return boardSize;
  }

  public void setBoardSize(int boardSize) {
    this.boardSize = boardSize;
  }

  public int getNumberOfSnakes() {
    return numberOfSnakes;
  }

  public void setNumberOfSnakes(int numberOfSnakes) {
    this.numberOfSnakes = numberOfSnakes;
  }

  public int getNumberOfLadders() {
    return numberOfLadders;
  }

  public void setNumberOfLadders(int numberOfLadders) {
    this.numberOfLadders = numberOfLadders;
  }

  public int getNumberOfDice() {
    return numberOfDice;
  }

  public void setNumberOfDice(int numberOfDice) {
    this.numberOfDice = numberOfDice;
  }

  public MovementStrategy getMovementStrategy() {
    return movementStrategy;
  }

  public void setMovementStrategy(MovementStrategy movementStrategy) {
    this.movementStrategy = movementStrategy;
  }

  public List<Point> getNumberOfSnakesPos() {
    return numberOfSnakesPos;
  }

  public void setNumberOfSnakesPos(List<Point> numberOfSnakesPos) {
    this.numberOfSnakesPos = numberOfSnakesPos;
  }

  public List<Point> getNumberOfLadderPos() {
    return numberOfLadderPos;
  }

  public void setNumberOfLadderPos(List<Point> numberOfLadderPos) {
    this.numberOfLadderPos = numberOfLadderPos;
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
