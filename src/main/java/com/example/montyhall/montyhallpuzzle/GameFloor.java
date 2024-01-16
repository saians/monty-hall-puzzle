package com.example.montyhall.montyhallpuzzle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class GameFloor {

  private static final int NUMBER_OF_BOXES = 3;

  private final Map<Integer, Box> boxes = new HashMap<>();

  public GameFloor() {
    //The prize box number is generated randomly
    int winningBoxNumber = RandomBoxNumber.generateRandomBoxNumber();

    IntStream.rangeClosed(1, NUMBER_OF_BOXES).forEach(boxNumber -> {

      //Getting ready the boxes for puzzle
      //Marking the box with prize as winning box
        Box box = Box.builder()
              .boxNum(boxNumber)
              .winning(boxNumber == winningBoxNumber)
              .build();
        boxes.put(boxNumber, box);
      }
    );
  }

  public Box getBoxByNumber(int number) {
    return boxes.get(number);
  }

  public void contestantSelectsBox(int number) {
    resetAllBoxesToNotSelected();

    //The box selected by contestant is marked
    getBoxByNumber(number).setSelectedByPlayer(true);
  }

  private void resetAllBoxesToNotSelected() {
    boxes.values().forEach(box -> box.setSelectedByPlayer(false));
  }

  public void hostOpensABox() {

    //Filtering out boxes that are false for selected and not the one that has prize
    List<Box> possibleBoxes = boxes.values().stream()
            .filter(box -> !box.isSelectedByPlayer())
            .filter(box -> !box.isWinning())
            .toList();

    if (possibleBoxes.size() == 1) {

      //Host opening the first box and marking it as opened
      possibleBoxes.get(0).setOpenedByGameHost(true);
    } else {
      int boxToOpen = new Random().nextInt(1) + 1;
      possibleBoxes.get(boxToOpen).setOpenedByGameHost(true);
    }

  }

  public void contestantChangesSelectedBox() {
    final Box boxToSelect = boxes.values().stream()
        .filter(box -> !box.isOpenedByGameHost())
        .filter(box -> !box.isSelectedByPlayer())
        .findFirst()
        .orElseThrow();
    resetAllBoxesToNotSelected();
    boxToSelect.setSelectedByPlayer(true);
  }

  public boolean hostOpensWinningBox() {
    final Box winningBox = boxes.values().stream()
        .filter(Box::isWinning)
        .findFirst()
        .orElseThrow();
    winningBox.setOpenedByGameHost(true);
    return winningBox.isSelectedByPlayer();
  }
}
