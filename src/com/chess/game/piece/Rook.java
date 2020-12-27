package com.chess.game.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.common.Coordinate;
import com.chess.common.CoordinateUtils;
import com.chess.game.board.ChessBoard;
import com.chess.game.square.Square;

public class Rook extends Piece implements Movable {

  public Rook(PieceColor color) {
    super(color);
    this.name = "Rook";
    this.key = "R";
    super.setIconPath();
  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board) {
    return getLegalMoves(board, getSquare());
  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board, Square currentSquare) {
    List<Coordinate> moves = new ArrayList<>();

    addMoves(moves, board, currentSquare, 1, 0);
    addMoves(moves, board, currentSquare, -1, 0);
    addMoves(moves, board, currentSquare, 0, 1);
    addMoves(moves, board, currentSquare, 0, -1);

    return moves;
  }

  private void addMoves(List<Coordinate> moves, ChessBoard board, Square currentSquare, int fileDirection,
      int rankDirection) {
    var map = board.getCoordinateSquareMap();
    var nextCoordinate = CoordinateUtils.offset(currentSquare.getCoordinate(), fileDirection, rankDirection);

    while (map.get(nextCoordinate) != null) {
      if (map.get(nextCoordinate).isEmpty()) {
        moves.add(nextCoordinate);
      } else if (map.get(nextCoordinate).getPiece().color != color) {
        moves.add(nextCoordinate);
        break;
      } else {
        break;
      }

      nextCoordinate = CoordinateUtils.offset(nextCoordinate, fileDirection, rankDirection);
    }
  }
}
