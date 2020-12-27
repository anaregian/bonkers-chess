package com.chess.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.chess.common.Consts;
import com.chess.game.board.ChessBoard;
import com.chess.gui.board.BoardPanel;
import com.chess.gui.menu.MenuBar;

public class GameWindow {
  private final JFrame frame = new JFrame("Bonkers Chess");

  public GameWindow(ChessBoard board) {
    var boardPanel = new BoardPanel(board);
    frame.setLayout(new BorderLayout());
    frame.setJMenuBar(new MenuBar(boardPanel));
    frame.add(boardPanel, BorderLayout.CENTER);
    frame.setSize(Consts.FRAME_DIMENSION);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

}
