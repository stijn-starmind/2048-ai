package be.stijnvermeeren.my2048ai.move

import be.stijnvermeeren.my2048ai.board.Board

trait Move extends InGameMove {
  def apply(board: Board): (Board, Int)

  def changes(board: Board): Boolean = apply(board)._1 != board
}
