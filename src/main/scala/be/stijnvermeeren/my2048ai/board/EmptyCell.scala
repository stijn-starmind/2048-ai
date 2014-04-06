package be.stijnvermeeren.my2048ai.board

case object EmptyCell extends Cell {
  override def toString: String = "-"
}
