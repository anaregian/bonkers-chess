package com.chess.game.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.common.Coordinate;
import com.chess.common.CoordinateUtils;
import com.chess.game.board.ChessBoard;
import com.chess.game.square.Square;

public class Knight extends Piece implements Movable {

  public Knight(PieceColor color) {
    super(color);
    this.name = "Knight";
    this.key = "N";
    this.mergeable = new Mergeable();
    super.setIconPath();
  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board) {
    return getLegalMoves(board, getSquare());
  }

  @Override
  public List<Coordinate> getLegalMoves(ChessBoard board, Square currentSquare) {
    List<Coordinate> moves = new ArrayList<>();

    addMove(moves, board, currentSquare, 2, 1);
    addMove(moves, board, currentSquare, 2, -1);
    addMove(moves, board, currentSquare, -2, 1);
    addMove(moves, board, currentSquare, -2, -1);
    addMove(moves, board, currentSquare, 1, 2);
    addMove(moves, board, currentSquare, 1, -2);
    addMove(moves, board, currentSquare, -1, 2);
    addMove(moves, board, currentSquare, -1, -2);

    if (mergeable.mergedPiece != null) {
      moves.addAll(mergeable.mergedPiece.getLegalMoves(board, currentSquare));
    }

    return moves;
  }

  private void addMove(List<Coordinate> moves, ChessBoard board, Square currentSquare, int fileOffset, int rankOffset) {
    var map = board.getCoordinateSquareMap();
    var targetCoordinate = CoordinateUtils.offset(currentSquare.getCoordinate(), fileOffset, rankOffset);

    if (map.get(targetCoordinate) != null
        && (map.get(targetCoordinate).isEmpty() || map.get(targetCoordinate).getPiece().getColor() != color
            || !mergeable.hasMerged && map.get(targetCoordinate).getPiece().getColor() == color
                && map.get(targetCoordinate).getPiece().mergeable != null)) {
      moves.add(targetCoordinate);
    }
  }

  @Override
  public void move(Square square) {
    if (square.getPiece() != null && square.getPiece().getColor() == color) {
      mergeable.mergeWith(square.getPiece());
    }
    super.move(square);
  }
}
