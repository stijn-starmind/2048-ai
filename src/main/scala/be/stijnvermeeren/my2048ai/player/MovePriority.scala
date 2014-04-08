package be.stijnvermeeren.my2048ai.player

import be.stijnvermeeren.my2048ai.move._
import be.stijnvermeeren.my2048ai.board.Board
import scala.annotation.tailrec

case class MovePriority() extends Player {
  val moves = List(Down, Right, Up, Left)

  final def decide(board: Board): InGameMove =
    moves.find(_.changes(board)).getOrElse(Quit)
}
