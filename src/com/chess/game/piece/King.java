package com.chess.game.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.common.Coordinate;
import com.chess.common.CoordinateUtils;
import com.chess.game.board.ChessBoard;
import com.chess.game.square.Square;

public class King extends Piece implements Movable {

  public King(PieceColor color) {
    super(color);
    this.name = "King";
    this.key = "K";
    super.setIconPath();
  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board) {
    List<Coordinate> moves = new ArrayList<>();

    addMove(moves, board, 1, 1);
    addMove(moves, board, 1, 0);
    addMove(moves, board, 1, -1);
    addMove(moves, board, 0, 1);
    addMove(moves, board, 0, -1);
    addMove(moves, board, -1, 1);
    addMove(moves, board, -1, 0);
    addMove(moves, board, -1, -1);

    return moves;
  }

  private void addMove(List<Coordinate> moves, ChessBoard board, int fileOffset, int rankOffset) {
    var map = board.getCoordinateSquareMap();
    var targetCoordinate = CoordinateUtils.offset(getSquare().getCoordinate(), fileOffset, rankOffset);

    if (map.get(targetCoordinate) != null
        && (map.get(targetCoordinate).isEmpty() || map.get(targetCoordinate).getPiece().getColor() != color)) {
      moves.add(targetCoordinate);
    }
  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board, Square currentSquare) {
    throw new UnsupportedOperationException();
  }
}
