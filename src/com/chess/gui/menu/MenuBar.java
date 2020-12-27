package com.chess.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.chess.gui.board.BoardPanel;

public class MenuBar extends JMenuBar {
  private static final long serialVersionUID = 5703906140576977620L;

  public MenuBar(BoardPanel boardPanel) {
    populateMenuBar(boardPanel);
  }

  private void populateMenuBar(BoardPanel boardPanel) {
    add(createFileMenuOption(boardPanel));
  }

  private JMenu createFileMenuOption(BoardPanel boardPanel) {
    final JMenu fileMenu = new JMenu("File");

    fileMenu.add(createNewGameMenuItem(boardPanel));

    return fileMenu;
  }

  private JMenuItem createNewGameMenuItem(BoardPanel boardPanel) {
    final JMenuItem newGameMenuItem = new JMenuItem("New Game");

    newGameMenuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        boardPanel.reset();
      }
    });

    return newGameMenuItem;
  }
}
