package be.stijnvermeeren.my2048ai.move

import be.stijnvermeeren.my2048ai.board.Board

case object GameStart extends AnyMove {
  def board: Board = Board.empty().addRandomCell().addRandomCell()
}
