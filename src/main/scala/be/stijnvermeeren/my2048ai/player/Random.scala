package be.stijnvermeeren.my2048ai.player

import scala.util.Random._

import be.stijnvermeeren.my2048ai.board.Board
import be.stijnvermeeren.my2048ai.move._

case class Random() extends Player {
  val moves = List(Down, Right, Up, Left)

  final def decide(board: Board): InGameMove =
    shuffle(moves.filter(_.changes(board))).headOption.getOrElse(Quit)
}
