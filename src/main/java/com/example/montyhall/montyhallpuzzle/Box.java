package com.example.montyhall.montyhallpuzzle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Box {
  private int boxNum;
  private boolean winning;
  private boolean selectedByPlayer;
  private boolean openedByGameHost;
}
