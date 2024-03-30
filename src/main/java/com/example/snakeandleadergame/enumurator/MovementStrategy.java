package com.example.snakeandleadergame.enumurator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MovementStrategy {
  SUM("SUM"),
  MAX("MAX"),
  MIN("MIN");

  private final String strategy;

  MovementStrategy(String strategy) {
    this.strategy = strategy;
  }

  @JsonValue
  public String getStrategy() {
    return strategy;
  }

  @JsonCreator
  public static MovementStrategy fromString(String text) {
    for (MovementStrategy strategy : MovementStrategy.values()) {
      if (strategy.strategy.equalsIgnoreCase(text)) {
        return strategy;
      }
    }
    throw new IllegalArgumentException("Unknown movement strategy: " + text);
  }
}