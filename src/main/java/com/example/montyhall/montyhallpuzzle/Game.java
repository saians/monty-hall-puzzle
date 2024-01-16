package com.example.montyhall.montyhallpuzzle;

import lombok.AllArgsConstructor;

import static com.example.montyhall.montyhallpuzzle.RandomBoxNumber.generateRandomBoxNumber;


@AllArgsConstructor
public class Game {

  private GameFloor gameFloor;
  private boolean contestantShouldChangeBox;

  /**
   * Main steps of the game are executed here
   */
  public boolean run() {

    // The number of box chosen by contestant is generated randomly
    int contestantChosenBoxNumber = generateRandomBoxNumber();

    gameFloor.contestantSelectsBox(contestantChosenBoxNumber);
    gameFloor.hostOpensABox();
    if (contestantShouldChangeBox) {
      gameFloor.contestantChangesSelectedBox();
    }
    return gameFloor.hostOpensWinningBox();
  }
}
