package com.chess.common;

import java.awt.Color;
import java.awt.Dimension;

public final class Consts {
  public static final int BOARD_LENGTH = 8;
  public static final int NUM_SQUARES = BOARD_LENGTH * BOARD_LENGTH;

  public static final Dimension FRAME_DIMENSION = new Dimension(700, 700);
  public static final Dimension BOARD_DIMENSION = new Dimension(600, 600);
  public static final Dimension SQUARE_DIMENSION = new Dimension(BOARD_DIMENSION.width / BOARD_LENGTH,
      BOARD_DIMENSION.height / BOARD_LENGTH);

  public static final Color LIGHT_SQUARE_COLOR = new Color(240, 217, 181);
  public static final Color DARK_SQUARE_COLOR = new Color(148, 111, 81);
}
