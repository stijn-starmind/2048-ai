package be.stijnvermeeren.my2048ai.board

import scala.annotation.tailrec
import be.stijnvermeeren.my2048ai._
import scala.Some

object Line {
  @tailrec
  def collapse(oldLine: Line, newLine: Line = Nil, stack: Option[ValueCell] = None, points: Int = 0): (Line, Int) = {
    oldLine match {
      case Nil => ((stack ++: newLine).reverse, points)
      case EmptyCell :: tail => collapse(tail, newLine, stack, points)
      case (cell @ ValueCell(value)) :: tail => stack match {
        case Some(`cell`) =>
          collapse(tail, ValueCell(2 * value) :: newLine, None, points + 2 * value)
        case Some(stackCell) =>
          collapse(tail, stackCell :: newLine, Some(cell), points)
        case None =>
          collapse(tail, newLine, Some(cell), points)
      }
    }
  }
}
