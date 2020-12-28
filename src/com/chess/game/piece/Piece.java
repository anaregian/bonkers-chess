package com.chess.game.piece;

import com.chess.game.square.Square;

public abstract class Piece implements Movable {
  protected String name;
  protected String key;
  protected String iconPath;
  protected PieceColor color;
  protected Square square;
  protected Mergeable mergeable = null;

  public Piece(PieceColor color) {
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public String getKey() {
    return key;
  }

  public PieceColor getColor() {
    return color;
  }

  public Square getSquare() {
    return square;
  }

  public String getIconPath() {
    return iconPath;
  }

  public void setIconPath() {
    this.iconPath = "assets/pieces/" + color.toString().charAt(0) + this.key + ".png";
    ;
  }

  public void setSquare(Square square) {
    this.square = square;
  }

  @Override
  public void move(Square square) {
    getSquare().clear();
    setSquare(square);
    square.putPiece(this);
  }

  @Override
  public String toString() {
    return name + color;
  }
}
