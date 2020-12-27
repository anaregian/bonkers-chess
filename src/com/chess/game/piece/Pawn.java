package com.chess.game.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.common.Coordinate;
import com.chess.common.CoordinateUtils;
import com.chess.game.board.ChessBoard;
import com.chess.game.square.Square;

public class Pawn extends Piece implements Movable {
  private boolean hasMoved = false;

  public Pawn(PieceColor color) {
    super(color);
    this.name = "Pawn";
    this.key = "p";
    super.setIconPath();
  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board) {
    List<Coordinate> moves = new ArrayList<>();

    addAdvancingMove(moves, board, 1);

    if (!hasMoved) {
      addAdvancingMove(moves, board, 2);
    }

    addCapture(moves, board, -1);
    addCapture(moves, board, 1);

    return moves;
  }

  private void addAdvancingMove(List<Coordinate> moves, ChessBoard board, int offset) {
    int direction = color == PieceColor.Black ? -1 : 1;
    var map = board.getCoordinateSquareMap();
    var targetCoordinate = CoordinateUtils.offset(getSquare().getCoordinate(), 0, direction * offset);

    if (map.get(targetCoordinate) != null && map.get(targetCoordinate).isEmpty()) {
      moves.add(targetCoordinate);
    }
  }

  private void addCapture(List<Coordinate> moves, ChessBoard board, int captureDirection) {
    int direction = color == PieceColor.Black ? -1 : 1;
    var map = board.getCoordinateSquareMap();
    var captureCoordinate = CoordinateUtils.offset(getSquare().getCoordinate(), captureDirection, direction);

    if (captureCoordinate != null && map.get(captureCoordinate) != null && map.get(captureCoordinate).getPiece() != null
        && map.get(captureCoordinate).getPiece().getColor() != color) {
      moves.add(captureCoordinate);
    }

  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board, Square currentSquare) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void move(Square square) {
    super.move(square);
    hasMoved = true;
  }
}
