package com.chess.game.piece;

import java.util.HashMap;
import java.util.Map;

import com.chess.common.Coordinate;
import com.chess.common.File;

public final class PieceUtils {
  public static Map<Coordinate, Piece> initPieces() {
    Map<Coordinate, Piece> pieces = new HashMap<>();

    pieces.put(new Coordinate(File.A, 1), new Rook(PieceColor.White));
    pieces.put(new Coordinate(File.H, 1), new Rook(PieceColor.White));
    pieces.put(new Coordinate(File.A, 8), new Rook(PieceColor.Black));
    pieces.put(new Coordinate(File.H, 8), new Rook(PieceColor.Black));

    pieces.put(new Coordinate(File.B, 1), new Knight(PieceColor.White));
    pieces.put(new Coordinate(File.G, 1), new Knight(PieceColor.White));
    pieces.put(new Coordinate(File.B, 8), new Knight(PieceColor.Black));
    pieces.put(new Coordinate(File.G, 8), new Knight(PieceColor.Black));

    pieces.put(new Coordinate(File.C, 1), new Bishop(PieceColor.White));
    pieces.put(new Coordinate(File.F, 1), new Bishop(PieceColor.White));
    pieces.put(new Coordinate(File.C, 8), new Bishop(PieceColor.Black));
    pieces.put(new Coordinate(File.F, 8), new Bishop(PieceColor.Black));

    pieces.put(new Coordinate(File.D, 1), new Queen(PieceColor.White));
    pieces.put(new Coordinate(File.D, 8), new Queen(PieceColor.Black));

    pieces.put(new Coordinate(File.E, 1), new King(PieceColor.White));
    pieces.put(new Coordinate(File.E, 8), new King(PieceColor.Black));

    for (File file : File.values()) {
      pieces.put(new Coordinate(file, 2), new Pawn(PieceColor.White));
      pieces.put(new Coordinate(file, 7), new Pawn(PieceColor.Black));
    }

    return pieces;
  }
}
