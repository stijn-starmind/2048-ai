package be.stijnvermeeren.my2048ai.player

import be.stijnvermeeren.my2048ai.move.InGameMove
import be.stijnvermeeren.my2048ai.board.Board

trait Player {
  def decide(board: Board): InGameMove
}
