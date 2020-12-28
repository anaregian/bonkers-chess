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

    addAdvancingMove(moves, board, currentSquare, 1);

    if (!hasMoved) {
      addAdvancingMove(moves, board, currentSquare, 2);
    }

    addCapture(moves, board, currentSquare, -1);
    addCapture(moves, board, currentSquare, 1);

    if (mergeable.mergedPiece != null) {
      moves.addAll(mergeable.mergedPiece.getLegalMoves(board, currentSquare));
    }

    return moves;
  }

  private void addAdvancingMove(List<Coordinate> moves, ChessBoard board, Square currentSquare, int offset) {
    int direction = color == PieceColor.Black ? -1 : 1;
    var map = board.getCoordinateSquareMap();
    var targetCoordinate = CoordinateUtils.offset(currentSquare.getCoordinate(), 0, direction * offset);

    if (map.get(targetCoordinate).isEmpty()) {
      moves.add(targetCoordinate);
    }
  }

  private void addCapture(List<Coordinate> moves, ChessBoard board, Square currentSquare, int captureDirection) {
    int direction = color == PieceColor.Black ? -1 : 1;
    var map = board.getCoordinateSquareMap();
    var captureCoordinate = CoordinateUtils.offset(currentSquare.getCoordinate(), captureDirection, direction);

    if (map.get(captureCoordinate) != null && map.get(captureCoordinate).getPiece() != null
        && (map.get(captureCoordinate).getPiece().getColor() != color
            || !mergeable.hasMerged && map.get(captureCoordinate).getPiece().getColor() == color
                && map.get(captureCoordinate).getPiece().mergeable != null)) {
      moves.add(captureCoordinate);
    }

  }

  @Override
  public void move(Square square) {
    hasMoved = true;
    if (square.getPiece() != null && square.getPiece().getColor() == color) {
      mergeable.mergeWith(square.getPiece());
    }
    super.move(square);
  }
}
