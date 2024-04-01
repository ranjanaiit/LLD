package com.example.snakeandleadergame;

import com.example.snakeandleadergame.entity.*;
import com.example.snakeandleadergame.enumurator.MovementStrategy;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class Board {
  List<Snake> snakes = new ArrayList<>();
  List<Ladder> ladders = new ArrayList<>();
  List<Crocodile> crocodiles = new ArrayList<>();
  List<Mine> Mines = new ArrayList<>();

  int boardSize;

  int noOfPlayers;

  MovementStrategy movementStrategy;

  Configuration configuration;
  public Board(Configuration configuration){
    this.configuration = configuration;
    getSnakes();
    getLadders();
    getCrocodiles();
    getMines();
    this.movementStrategy = configuration.getMovementStrategy();
    this.boardSize = configuration.getBoardSize();
    this.noOfPlayers = configuration.getPlayers();
  }

  private void getMines() {
    List<Mine> mines = new ArrayList<>();
    for(int i = 0; i < configuration.getNumberOfMine(); i++) {
      Point point = configuration.getNumberOfMinePos().get(i);
      mines.add(new Mine(i,point));
    }
    this.Mines = mines;
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
  public void getCrocodiles() {
   List<Crocodile> crocodiles = new ArrayList<>();
   for(int i = 0; i < configuration.getNumberOfCrocodile(); i++) {
     Point point = configuration.getNumberOfCrocodilePos().get(i);
     crocodiles.add(new Crocodile(i,point));
     this.crocodiles = crocodiles;
   }
  }
}
