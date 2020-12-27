package com.chess.game.square;

import com.chess.common.Coordinate;
import com.chess.game.piece.Piece;

public class Square {
  private final Coordinate coordinate;
  private boolean isEmpty = true;
  private Piece piece;

  public Square(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  public void clear() {
    isEmpty = true;
    piece = null;
  }

  public void putPiece(Piece piece) {
    isEmpty = false;
    this.piece = piece;
  }

  public boolean isEmpty() {
    return isEmpty;
  }

  public Piece getPiece() {
    return piece;
  }

  public SquareColor getSquareColor(Coordinate coordinate) {
    if ((coordinate.getFile().ordinal() + coordinate.getRank()) % 2 == 0) {
      return SquareColor.Light;
    }

    return SquareColor.Dark;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  @Override
  public String toString() {
    return piece + " - " + coordinate;
  }
}
