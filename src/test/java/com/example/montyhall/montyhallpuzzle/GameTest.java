package com.example.montyhall.montyhallpuzzle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void changingBoxIncreaseWinningChances(){
        int numberOfSimulations = 500;
        boolean changedTheBox = true;
        boolean notChangedTheBox = false;

        //Case 1: without changing box
        GameRunner runWithoutChangingTheBox = new GameRunner(notChangedTheBox);
        runWithoutChangingTheBox.runGameShows(numberOfSimulations);
        double winPercentageWithoutBoxChanged = runWithoutChangingTheBox.getWinPercent();

        //Case 1: with changing box
        GameRunner runWithChangingTheBox = new GameRunner(changedTheBox);
        runWithChangingTheBox.runGameShows(numberOfSimulations);
        double winPercentageWithBoxChanged = runWithChangingTheBox.getWinPercent();

        Assertions.assertTrue(winPercentageWithBoxChanged > winPercentageWithoutBoxChanged);
    }
}
