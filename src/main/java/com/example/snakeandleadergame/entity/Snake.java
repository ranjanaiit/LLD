package com.example.snakeandleadergame.entity;


import com.example.snakeandleadergame.entity.Point;
import lombok.Data;

@Data
public class Snake  implements Huddle{

  int no;
  Point point;

  public Snake(int no, Point point) {
    this.no = no;
    this.point = point;
  }

  @Override
  public void setPlayerPosition(Player currentPlayer) {
    currentPlayer.setPosition(this.getPoint().getStart());

  }
}
