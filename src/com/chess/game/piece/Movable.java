package com.chess.game.piece;

import java.util.List;

import com.chess.common.Coordinate;
import com.chess.game.board.ChessBoard;
import com.chess.game.square.Square;

public interface Movable {
	List<Coordinate> getLegalMoves(ChessBoard board);
	
	List<Coordinate> getLegalMoves(ChessBoard board, Square currentSquare);

	void move(Square square);
}
