package com.chess;

import javax.swing.UIManager;

import com.chess.game.board.ChessBoard;
import com.chess.gui.GameWindow;

public class Game {

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }

    new GameWindow(new ChessBoard());
  }
}
