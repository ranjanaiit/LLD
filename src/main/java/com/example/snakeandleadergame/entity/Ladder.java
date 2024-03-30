package com.example.snakeandleadergame.entity;


import lombok.Data;

@Data
public class Ladder {
  int no;
  Point point;

  public Ladder(int no, Point point) {
    this.no = no;
    this.point = point;

  }
}
