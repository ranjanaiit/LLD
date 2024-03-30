package com.example.snakeandleadergame;

import com.example.snakeandleadergame.entity.Ladder;
import com.example.snakeandleadergame.entity.Player;
import com.example.snakeandleadergame.entity.Snake;
import com.example.snakeandleadergame.enumurator.MovementStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class GameService {

  private static final Logger LOGGER = Logger.getLogger("GameService");

  Board board;
  List<Player> players;
  public GameService(Board board) {
    LOGGER.info("Game service has started! ready to play ");
    this.board = board;
    initializePlayers();
  }

  private void initializePlayers() {
    List<Player> players = new ArrayList<>();
    for(int i = 0; i < board.configuration.getPlayers(); i++) {
      players.add(new Player(i, 1));
    }
    this.players = players;
    LOGGER.info("All player has been added to the game ");
  }

  public void play(MovementStrategy movementStrategy) {
    int currentPlayerIndex = 0;
    while(true) {
      int moveCount = throwDice(movementStrategy);
      Player currentPlayer = players.get(currentPlayerIndex);
      LOGGER.info("player "+ currentPlayerIndex + " rolled a " + moveCount);
      setNextPostion(currentPlayer, moveCount);
      if(checkhasWon(currentPlayer)){
        LOGGER.info("Player " + currentPlayer.getId() + " wins");
        return;
      }
      currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
      System.out.println();
    }
  }

  public boolean checkhasWon(Player currentPlayer) {
    if(currentPlayer.getPosition() == board.configuration.getBoardSize()) {
      return true;
    }
    return false;
  }

  public void setNextPostion(Player currentPlayer, int moveCount) {
    if(currentPlayer.getPosition() + moveCount > board.configuration.getBoardSize()) {
      LOGGER.info("player " + currentPlayer.getId() + " can move as final move count is out of board");
      return;
    }


    for(Snake snake : board.snakes) {
      if(snake.getPoint().getEnd() == currentPlayer.getPosition() + moveCount) {
        LOGGER.info("SAD! "+currentPlayer.getId() + " beaten by snake at position "+ snake.getPoint().getEnd());
        currentPlayer.setPosition(snake.getPoint().getStart());
        return;
      }
    }

    for(Ladder ladder : board.ladders) {
      if(ladder.getPoint().getStart() == currentPlayer.getPosition() + moveCount) {
        currentPlayer.setPosition(ladder.getPoint().getEnd());
        LOGGER.info("GOOD LUCK! " + currentPlayer.getId() + " has got to position "+ ladder.getPoint().getEnd());
        return;
      }
    }

    for(Player player : players){
      if(player.getId() != currentPlayer.getId() && player.getPosition() == currentPlayer.getPosition()+moveCount){
        player.setPosition(1);
        LOGGER.info("Player "+ currentPlayer.getId() + " beats player "+ player.getId() + " at position "+ (currentPlayer.getPosition()+moveCount));
      }
    }
    currentPlayer.setPosition(currentPlayer.getPosition() + moveCount);
    LOGGER.info("Current player " +currentPlayer.getId() + " has current position " +currentPlayer.getPosition());
  }

  private int throwDice(MovementStrategy movementStrategy) {
    int noOfDice = board.configuration.getNumberOfDice();
    int dice = 0;
    switch (movementStrategy) {
      case MAX:
       dice = getDiceWithMaxValue(noOfDice);
        break;
      case MIN:
       dice = getDiceWithMinValue(noOfDice) ;
        System.out.println("Ladder movement");
        break;
      case SUM:
       dice = getDiceWithSumValue(noOfDice);
        System.out.println("Normal movement");
        break;
    }
    return dice ;
  }

  public int getDiceWithSumValue(int noOfDice) {
    Random random = new Random();
    int sumRoll = 0;

    for (int i = 0; i < noOfDice; i++) {
      int roll = random.nextInt(6) + 1; // Simulate rolling a six-sided die
      sumRoll = sumRoll+roll;
    }

    return sumRoll;
  }

  public int getDiceWithMinValue(int noOfDice) {
    Random random = new Random();
    int minRoll = 7;

    for (int i = 0; i < noOfDice; i++) {
      int roll = random.nextInt(6) + 1; // Simulate rolling a six-sided die
      if (roll < minRoll) {
        minRoll = roll;
      }
    }

    return minRoll;
  }

  public int getDiceWithMaxValue(int noOfDice) {
    Random random = new Random();
    int maxRoll = 0;

    for (int i = 0; i < noOfDice; i++) {
      int roll = random.nextInt(6) + 1; // Simulate rolling a six-sided die
      if (roll > maxRoll) {
        maxRoll = roll;
      }
    }

    return maxRoll;
  }
}
