package be.stijnvermeeren.my2048ai

case class Board(cells: CellArray) {
  def addRandomCell(count: Int = 1): Board = ???

  def emptyCoords: List[(Int, Int)] = ???
}

object Board {
  def empty(height: Int = Config.boardHeight, width: Int = Config.boardWidth): Board =
    new Board(Array.fill[Cell](height, width)(EmptyCell)).addRandomCell(2)
}
