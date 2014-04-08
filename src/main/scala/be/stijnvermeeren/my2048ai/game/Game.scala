package be.stijnvermeeren.my2048ai.game

import be.stijnvermeeren.my2048ai.move.{Move, GameStart}

case class Game(state: State, history: List[State] = Nil) {
  def move(move: Move): Game = {
    state.move(move) match {
      case Some(newState) => Game(newState, fullHistory)
      case None => throw new Exception(s"Tried to move in an illegal direction ($move)")
    }
  }

  lazy val fullHistory: List[State] = state :: history
}

object Game {
  def start(): Game = {
    val startState = State(GameStart, GameStart.board, 0)
    new Game(startState)
  }
}