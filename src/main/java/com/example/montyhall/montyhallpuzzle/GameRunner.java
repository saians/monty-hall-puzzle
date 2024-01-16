package com.example.montyhall.montyhallpuzzle;

import java.util.stream.IntStream;

public class GameRunner {

  private double winCount = 0;
  private double totalCount = 0;

  private final boolean contestantShouldChangeBox;

  public GameRunner(boolean contestantShouldChangeBox) {
    this.contestantShouldChangeBox = contestantShouldChangeBox;
  }


  public void runGameShows(int count) {
    IntStream.rangeClosed(1, count).forEach(this::run);
  }

  private void run(int showNumber) {
    boolean contestantWins = new Game(new GameFloor(), contestantShouldChangeBox).run();
    totalCount++;
    if (contestantWins) {
      winCount++;
    }
  }

  public double getWinPercent() {
    return (winCount/totalCount)*100;
  }

  public String getWinCountFraction() {
    FractionValue fractionValue = new FractionValue();
    return fractionValue.displayFractionValue(winCount,totalCount);
  }

}
