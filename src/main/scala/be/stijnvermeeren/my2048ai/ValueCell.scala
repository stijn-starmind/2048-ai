package be.stijnvermeeren.my2048ai

import scala.util.Random

case class ValueCell(exponent: Int) extends Cell {
  lazy val value: BigInt = BigInt(2).pow(exponent)
}

object ValueCell {
  def random(): ValueCell = {
    val exponent = Random.nextInt(1) + 1
    new ValueCell(exponent)
  }
}
