package com.chess.gui.board;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.chess.common.Consts;
import com.chess.game.board.ChessBoard;
import com.chess.game.square.Square;
import com.chess.game.square.SquareColor;

public class SquarePanel extends JPanel {
  private static final long serialVersionUID = 1374277208568681012L;

  private Square square;

  public SquarePanel(BoardPanel boardPanel, Square square) {
    super(new GridBagLayout());
    this.square = square;
    addClickAction(boardPanel);
    setPreferredSize(Consts.SQUARE_DIMENSION);
    validate();
  }

  public void draw(ChessBoard board) {
    removeAll();
    assignTileColor();
    printPiece();
    highlightLegalMoves(board);
    repaint();
    validate();
  }

  private void assignTileColor() {
    if (square.getSquareColor(square.getCoordinate()) == SquareColor.Light) {
      setBackground(Consts.LIGHT_SQUARE_COLOR);
    } else {
      setBackground(Consts.DARK_SQUARE_COLOR);
    }
  }

  private void printPiece() {
    if (square.getPiece() != null) {
      try {
        add(new JLabel(new ImageIcon(ImageIO.read(new File(square.getPiece().getIconPath())))));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void highlightLegalMoves(ChessBoard board) {
    if (board.getValidMoves().contains(square.getCoordinate())) {
      if (square.getPiece() != null) {
        setBorder(BorderFactory.createLineBorder(new Color(52, 195, 0), 5));
      } else {
        try {
          add(new JLabel(new ImageIcon(ImageIO.read(new File("assets/img/green-dot.png")))));
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } else {
      setBorder(null);
    }
  }

  private void addClickAction(BoardPanel boardPanel) {
    addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        if (boardPanel.getSelectedSquarePanel() != null
            && boardPanel.getBoard().getValidMoves().contains(square.getCoordinate())) {
          movePiece(boardPanel);
        } else {
          getValidMoves(boardPanel);
        }
        boardPanel.draw(boardPanel.getBoard());
      }

      @Override
      public void mousePressed(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }
    });
  }

  private void getValidMoves(BoardPanel boardPanel) {
    if (square.getPiece() == null) {
      boardPanel.getBoard().setValidMoves(new ArrayList<>());
      boardPanel.setSelectedSquarePanel(null);
    } else {
      var moves = square.getPiece().getLegalMoves(boardPanel.getBoard());
      boardPanel.getBoard().setValidMoves(moves);
      boardPanel.setSelectedSquarePanel(this);
    }
  }

  private void movePiece(BoardPanel boardPanel) {
    boardPanel.getSelectedSquarePanel().square.getPiece().move(square);
    boardPanel.getBoard().setValidMoves(new ArrayList<>());
    boardPanel.setSelectedSquarePanel(null);
    ;
  }
}
