package com.chess.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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
    newGameMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));

    newGameMenuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        boardPanel.reset();
      }
    });

    return newGameMenuItem;
  }
}
