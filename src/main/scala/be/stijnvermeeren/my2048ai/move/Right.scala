package be.stijnvermeeren.my2048ai.move

import be.stijnvermeeren.my2048ai.board.Board

case object Right extends Move {
  def apply(board: Board): (Board, Int) = {
    board.rows.reverseCollapse match {
      case (rows, score) => (Board.fromRows(board.width, board.height, rows), score)
    }
  }
}
