package be.stijnvermeeren.my2048ai.player

import be.stijnvermeeren.my2048ai.move.InGameMove
import be.stijnvermeeren.my2048ai.board.Board
import org.slf4j.LoggerFactory

trait Player {
  def decide(board: Board): InGameMove

  def tell(message: String): Unit = {}
}
