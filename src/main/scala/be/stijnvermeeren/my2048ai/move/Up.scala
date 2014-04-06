package be.stijnvermeeren.my2048ai.move

import be.stijnvermeeren.my2048ai.board.Board

case object Up extends Move {
  def apply(board: Board): (Board, Int) = {
    board.columns.collapse match {
      case (columns, score) => (Board.fromColumns(board.width, board.height, columns), score)
    }
  }
}
