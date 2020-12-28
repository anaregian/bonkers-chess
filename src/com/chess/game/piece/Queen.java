package com.chess.game.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.common.Coordinate;
import com.chess.game.board.ChessBoard;
import com.chess.game.square.Square;

public class Queen extends Piece implements Movable {
  private Piece bishop;
  private Piece rook;

  public Queen(PieceColor color) {
    this(color, new Bishop(color), new Rook(color));
  }

  private Queen(PieceColor color, Piece bishop, Piece rook) {
    super(color);
    this.name = "Queen";
    this.key = "Q";
    this.bishop = bishop;
    this.rook = rook;
    this.mergeable = new Mergeable();
    setIconPath();
  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board) {
    return getLegalMoves(board, getSquare());
  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board, Square currentSquare) {
    List<Coordinate> moves = new ArrayList<>();

    moves.addAll(bishop.getLegalMoves(board, currentSquare));
    moves.addAll(rook.getLegalMoves(board, currentSquare));

    if (mergeable.mergedPiece != null) {
      moves.addAll(mergeable.mergedPiece.getLegalMoves(board, getSquare()));
    }

    return moves;
  }

  @Override
  public void move(Square square) {
    if (square.getPiece() != null && square.getPiece().getColor() == color) {
      bishop.mergeable.mergeWith(square.getPiece());
      rook.mergeable.mergeWith(square.getPiece());
    }
    super.move(square);
  }
}
