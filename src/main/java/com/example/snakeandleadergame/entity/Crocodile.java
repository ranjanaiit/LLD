package com.example.snakeandleadergame.entity;


import lombok.Data;

@Data
public class Crocodile implements Huddle {

  int no;
  Point point;

  public Crocodile(int no, Point point) {
    this.no = no;
    this.point = point;
  }


  @Override
  public void setPlayerPosition(Player currentPlayer) {
      currentPlayer.setPosition(Math.max(1, currentPlayer.getPosition() - this.getPoint().getStart()));
  }

}
