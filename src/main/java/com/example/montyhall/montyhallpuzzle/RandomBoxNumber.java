package com.example.montyhall.montyhallpuzzle;

import java.util.Random;

public class RandomBoxNumber {

  public static int generateRandomBoxNumber() {
    return new Random().nextInt(3) + 1;
  }
}
