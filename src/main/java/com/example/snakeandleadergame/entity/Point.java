package com.example.snakeandleadergame.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Point {
  @JsonProperty("start")
  int start;
  @JsonProperty("end")
  int end;
  public Point() {
  }
  public Point(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
