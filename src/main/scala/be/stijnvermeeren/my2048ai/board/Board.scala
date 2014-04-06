package be.stijnvermeeren.my2048ai.board

import scala.util.Random
import be.stijnvermeeren.my2048ai.move.Move
import be.stijnvermeeren.my2048ai._
import scala.Some
import scala.Some

case class Board(width: Int, height: Int, cells: CellMap) {
  /**
   * Add a random cell if possible, otherwise return the current board. Note that after a valid move,
   * there should always be at least one empty cell, so it's not critical to check whether we actually
   * added a random cell or not.
   */
  def addRandomCell(): Board = {
    emptyCoords match {
      case Nil => this
      case coords => this.copy(cells = cells + (Random.shuffle(emptyCoords).head -> ValueCell.random))
    }
  }

  def move(move: Move): (Board, Int) = move(this)

  def emptyCoords: List[(Int, Int)] = cells.filter(_._2 == EmptyCell).keys.toList

  def rows: List[Line] = {
    {
      for (y <- 0 until height) yield {
        {
          for (x <- 0 until width) yield {
            cells(x, y)
          }
        }.toList
      }
    }.toList
  }

  def columns: List[Line] = {
    {
      for (x <- 0 until width) yield {
        {
          for (y <- 0 until height) yield {
            cells(x, y)
          }
        }.toList
      }
    }.toList
  }

  override def toString: String =
    rows map (_.map(_.toString.padTo(6, " ").mkString).mkString) mkString "\n"
}

object Board {
  def empty(width: Int = Config.boardWidth, height: Int = Config.boardHeight): Board = {
    val cellMap = {
      for {
        x <- 0 until width
        y <- 0 until height
      } yield {
        (x, y) -> EmptyCell
      }
    }.toMap
    new Board(width, height, cellMap)
  }

  def fromColumns(width: Int, height: Int, rows: List[Line]): Board = {
    val cells = {
      for {
        (column, x) <- rows.zipWithIndex
        (cell, y) <- column.padTo(height, EmptyCell).zipWithIndex
      } yield {
        (x,y) -> cell
      }
    }.toMap
    new Board(width, height, cells)
  }

  def fromRows(width: Int, height: Int, rows: List[Line]): Board = {
    val cells = {
      for {
        (row, y) <- rows.zipWithIndex
        (cell, x) <- row.padTo(width, EmptyCell).zipWithIndex
      } yield {
        (x,y) -> cell
      }
    }.toMap
    new Board(width, height, cells)
  }
}
