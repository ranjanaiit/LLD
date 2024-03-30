package com.example.snakeandleadergame;

import com.example.snakeandleadergame.entity.Configuration;
import com.example.snakeandleadergame.entity.Ladder;
import com.example.snakeandleadergame.entity.Point;
import com.example.snakeandleadergame.entity.Snake;
import com.example.snakeandleadergame.enumurator.MovementStrategy;

import java.util.ArrayList;
import java.util.List;

public class Board {
  List<Snake> snakes = new ArrayList<>();
  List<Ladder> ladders = new ArrayList<>();

  int boardSize;

  int noOfPlayers;

  MovementStrategy movementStrategy;

  Configuration configuration;
  public Board(Configuration configuration){
    this.configuration = configuration;
    getSnakes();
    getLadders();
    this.movementStrategy = configuration.getMovementStrategy();
    this.boardSize = configuration.getBoardSize();
    this.noOfPlayers = configuration.getPlayers();
  }

  private void getLadders() {
    List<Ladder> ladders = new ArrayList<>();
    for(int i = 0; i < configuration.getNumberOfLadders(); i++) {
      Point point = configuration.getNumberOfLadderPos().get(i);
      ladders.add(new Ladder(i,point));
    }
    this.ladders = ladders;
  }


  public void getSnakes() {
   List<Snake> snakes = new ArrayList<>();
   for(int i = 0; i < configuration.getNumberOfSnakes(); i++) {
     Point point = configuration.getNumberOfLadderPos().get(i);
     snakes.add(new Snake(i,point));
     this.snakes = snakes;
   }
  }
}
