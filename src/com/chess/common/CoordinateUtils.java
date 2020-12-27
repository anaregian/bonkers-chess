package com.chess.common;

public class CoordinateUtils {
  public static Coordinate offset(Coordinate coordinate, int fileOffset, int rankOffset) {
    int file = coordinate.getFile().ordinal();

    if (file + fileOffset >= File.values().length || file + fileOffset < 0) {
      return null;
    }

    return new Coordinate(File.values()[file + fileOffset], coordinate.getRank() + rankOffset);
  }
}
