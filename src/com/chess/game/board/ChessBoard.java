package com.chess.game.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chess.common.Consts;
import com.chess.common.Coordinate;
import com.chess.common.File;
import com.chess.game.piece.Piece;
import com.chess.game.piece.PieceUtils;
import com.chess.game.square.Square;

public class ChessBoard {
  private Square[][] squares = new Square[Consts.BOARD_LENGTH][Consts.BOARD_LENGTH];

  private Map<Coordinate, Square> coordinateSquareMap;
  private Map<Coordinate, Piece> pieces;

  private List<Coordinate> validMoves = new ArrayList<>();

  public ChessBoard() {
    initializeBoard();
  }

  public Map<Coordinate, Square> getCoordinateSquareMap() {
    return coordinateSquareMap;
  }

  public Square[][] getSquares() {
    return squares;
  }

  public void setValidMoves(List<Coordinate> validMoves) {
    this.validMoves = validMoves;
  }

  public List<Coordinate> getValidMoves() {
    return validMoves;
  }

  public void reset() {
    initializeBoard();
  }

  private void initializeBoard() {
    coordinateSquareMap = new HashMap<>();
    pieces = PieceUtils.initPieces();

    for (int i = 0; i < squares.length; i++) {
      for (File file : File.values()) {
        var coordinate = new Coordinate(file, Consts.BOARD_LENGTH - i);
        var square = new Square(coordinate);

        if (pieces.containsKey(square.getCoordinate())) {
          putPieceOnSquare(square);
        }

        coordinateSquareMap.put(coordinate, square);
        squares[i][file.ordinal()] = square;
      }
    }
  }

  private void putPieceOnSquare(Square square) {
    var piece = pieces.get(square.getCoordinate());

    square.putPiece(piece);
    piece.setSquare(square);
  }

  @Override
  public String toString() {
    var builder = new StringBuilder();

    for (int i = 0; i < squares.length; i++) {
      builder.append(Consts.BOARD_LENGTH - i + " ");
      for (int j = 0; j < squares[i].length; j++) {
        if (squares[i][j].isEmpty()) {
          builder.append("- ");
        } else {
          builder.append(squares[i][j].getPiece().getKey() + " ");
        }
      }
      builder.append("\n");
    }

    builder.append("  ");
    for (File file : File.values()) {
      builder.append(file.name() + " ");
    }

    builder.append("\n");

    return builder.toString();
  }
}
