package com.example.snakeandleadergame.entity;


import lombok.Data;

@Data
public class Player {
  int id;
  int position;

  public Player(int id, int position) {
    this.id = id;
    this.position = position;
  }
}
