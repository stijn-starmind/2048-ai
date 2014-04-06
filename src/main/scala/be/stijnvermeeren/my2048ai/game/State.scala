package be.stijnvermeeren.my2048ai.game

import be.stijnvermeeren.my2048ai.move._
import be.stijnvermeeren.my2048ai.board.Board

case class State(lastMove: AnyMove, board: Board, score: Int) {
  def move(move: Move): Option[State] = {
    board.move(move) match {
      case (`board`, _) => None
      case (movedBoard, points) => Some(State(move, movedBoard.addRandomCell(), score + points))
    }
  }

  def gameOver: Boolean = {
    val moves = List(Up, Down, Left, Right)
    moves.map(move(_)).flatten.size == 0
  }

  override def toString: String = {
    List(lastMove.toString, board.toString, s"Score: $score") mkString "\n"
  }
}

