package be.stijnvermeeren.my2048ai

case class GameStart(board: Board) extends Move

object GameStart {
  def apply: GameStart = {
    val emptyBoard = Board()
  }
}
