package com.chess.game.piece;

public class Mergeable {
  protected Movable mergedPiece;
  protected boolean hasMerged;

  public Mergeable() {
    mergedPiece = null;
    hasMerged = false;
  }

  public void mergeWith(Piece piece) {
    mergedPiece = piece;
    hasMerged = true;
    piece.mergeable.hasMerged = true;
  }
}
