package be.stijnvermeeren.my2048ai

package object board {
  type CellMap = Map[(Int, Int), Cell]

  type Line = List[Cell]

  implicit class ListLineImplicits(lines: List[Line]) {
    def collapse: (List[Line], Int) = unpack(lines.map(_.collapse))

    def reverseCollapse: (List[Line], Int) = unpack(lines.map(_.reverseCollapse))

    private def unpack(packed: List[(Line, Int)]): (List[Line], Int) = {
      packed.unzip match {
        case (newLines, scores) => (newLines, scores.sum)
      }
    }
  }

  implicit class LineImplicits(line: Line) {
    def collapse: (Line, Int) = Line.collapse(line) match {
      case (collapsedLine, points) => (collapsedLine.padTo(line.size, EmptyCell), points)
    }

    def reverseCollapse: (Line, Int) = line.reverse.collapse match {
      case (reversedLine, points) => (reversedLine.reverse, points)
    }
  }
}
