package com.example.snakeandleadergame.entity;


import com.example.snakeandleadergame.entity.Point;
import lombok.Data;

@Data
public class Snake {

  int no;
  Point point;

  public Snake(int no, Point point) {
    this.no = no;
    this.point = point;
  }
}
