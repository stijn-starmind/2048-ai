package be.stijnvermeeren.my2048ai.player

import be.stijnvermeeren.my2048ai.move._
import be.stijnvermeeren.my2048ai.board.Board
import scala.annotation.tailrec

case class Human() extends Player {
  @tailrec
  final def decide(board: Board): InGameMove = {
    tell("Decide move (1=left, 2=down, 3=right, 5=up, q=quit, u=undo):")
    Console.in.readLine() match {
      case "1" => check(board, Left)
      case "2" => check(board, Down)
      case "3" => check(board, Right)
      case "5" => check(board, Up)
      case "q" => Quit
      case "u" => Undo
      case input =>
        tell(s"Unknown move $input, please try again.")
        decide(board)
    }
  }

  private def check(board: Board, move: Move): InGameMove = {
    if (move.changes(board)) {
      move
    } else {
      println(s"Illegal move $move, please try again.")
      decide(board)
    }
  }

  override def tell(message: String): Unit = {
    println()
    println(message)
  }
}
