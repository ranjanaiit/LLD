package com.example.snakeandleadergame.entity;


import lombok.Data;

@Data
public class Ladder implements Huddle{
  int no;
  Point point;

  public Ladder(int no, Point point) {
    this.no = no;
    this.point = point;

  }

  @Override
  public void setPlayerPosition(Player currentPlayer) {
    currentPlayer.setPosition(this.getPoint().getEnd());
  }
}
