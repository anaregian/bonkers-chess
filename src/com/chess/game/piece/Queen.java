package com.chess.game.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.common.Coordinate;
import com.chess.game.board.ChessBoard;
import com.chess.game.square.Square;

public class Queen extends Piece implements Movable {
  private Movable bishop;
  private Movable rook;

  public Queen(PieceColor color) {
    this(color, new Bishop(color), new Rook(color));
  }

  private Queen(PieceColor color, Movable bishop, Movable rook) {
    super(color);
    this.name = "Queen";
    this.key = "Q";
    this.bishop = bishop;
    this.rook = rook;
    super.setIconPath();
  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board) {
    List<Coordinate> moves = new ArrayList<>();
    moves.addAll(bishop.getLegalMoves(board, getSquare()));
    moves.addAll(rook.getLegalMoves(board, getSquare()));
    return moves;
  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board, Square currentSquare) {
    throw new UnsupportedOperationException();
  }
}
