package com.example.montyhall.montyhallpuzzle;

public class GameApp {
    public static void main(String[] args) {

        System.out.println("""

                 +-+-+-+-+-+ +-+-+-+-+ +-+-+-+-+
                 |M|o|n|t|y| |H|a|l|l| |G|a|m|e|
                 +-+-+-+-+-+ +-+-+-+-+ +-+-+-+-+
                """);

        int numberOfSimulations = 500;

        final GameRunner runWithoutChangingTheBox = new GameRunner(false);
        runWithoutChangingTheBox.runGameShows(numberOfSimulations);
        System.out.println("Executed the game " + numberOfSimulations + " times without changing the selected box.");
        System.out.println("Summary: Contestant wins in " + runWithoutChangingTheBox.getWinCountFraction()
                + " which is " + runWithoutChangingTheBox.getWinPercent() + "%");

        System.out.println("___________________________________________________________________");


        final GameRunner runWithChangedBox = new GameRunner(true);
        runWithChangedBox.runGameShows(numberOfSimulations);
        System.out.println("Executed the game " + numberOfSimulations + " times and contestant changed box every time.");
        System.out.println("Summary: Contestant wins in " + runWithChangedBox.getWinCountFraction()
                + " which is " + runWithChangedBox.getWinPercent() + "%");
        System.out.println("___________________________________________________________________");
    }
}
