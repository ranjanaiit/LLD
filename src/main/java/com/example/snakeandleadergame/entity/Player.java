package com.example.snakeandleadergame.entity;


import lombok.Data;

@Data
public class Player{
  int id;
  int position;
  String name;
  int holdTurn= 0;

  public Player(int id, int position,String name) {
    this.id = id;
    this.position = position;
    this.name = name;
  }

}
