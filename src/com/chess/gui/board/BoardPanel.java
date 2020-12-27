package com.chess.gui.board;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.chess.common.Consts;
import com.chess.game.board.ChessBoard;

public class BoardPanel extends JPanel {
  private static final long serialVersionUID = 4563108118070823161L;

  private ChessBoard board;
  private SquarePanel selectedSquarePanel;

  private List<SquarePanel> squarePanels;

  public BoardPanel(ChessBoard board) {
    super(new GridLayout(Consts.BOARD_LENGTH, Consts.BOARD_LENGTH));
    this.board = board;
    init();
    draw(board);

    setPreferredSize(Consts.BOARD_DIMENSION);
    validate();
  }

  public void init() {
    squarePanels = new ArrayList<>();
    var squares = board.getSquares();
    for (int i = 0; i < squares.length; i++) {
      for (int j = 0; j < squares.length; j++) {
        final SquarePanel squarePanel = new SquarePanel(this, squares[i][j]);
        squarePanels.add(squarePanel);
      }
    }
  }

  public ChessBoard getBoard() {
    return board;
  }

  public SquarePanel getSelectedSquarePanel() {
    return selectedSquarePanel;
  }

  public void setSelectedSquarePanel(SquarePanel selectedSquarePanel) {
    this.selectedSquarePanel = selectedSquarePanel;
  }

  public void reset() {
    board.reset();
    init();
    draw(board);
  }

  public void draw(ChessBoard board) {
    removeAll();
    for (SquarePanel squarePanel : squarePanels) {
      squarePanel.draw(board);
      add(squarePanel);
    }
    validate();
    repaint();
  }
}
