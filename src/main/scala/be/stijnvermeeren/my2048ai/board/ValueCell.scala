package be.stijnvermeeren.my2048ai.board

import scala.util.Random

case class ValueCell(value: Int) extends Cell {
  override def toString: String = value.toString
}

object ValueCell {
  // 90% probability for 2, 10% probability for 4
  val randomValues = List(2, 2, 2, 2, 2, 2, 2, 2, 2, 4)

  def random(): ValueCell = new ValueCell(Random.shuffle(randomValues).head)
}
