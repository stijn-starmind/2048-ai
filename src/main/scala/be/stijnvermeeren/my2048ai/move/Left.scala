package be.stijnvermeeren.my2048ai.move

import be.stijnvermeeren.my2048ai.board.Board

case object Left extends Move {
  def apply(board: Board): (Board, Int) = {
    board.rows.collapse match {
      case (rows, score) => (Board.fromRows(board.width, board.height, rows), score)
    }
  }
}
