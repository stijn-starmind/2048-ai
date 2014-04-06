package be.stijnvermeeren.my2048ai

import scala.annotation.tailrec

import be.stijnvermeeren.my2048ai.game.Game
import be.stijnvermeeren.my2048ai.move.{Move, Quit, Undo}
import be.stijnvermeeren.my2048ai.player.{Human, Player}

object Main extends App {
  val game = Game.start()
  val player = Human()
  play(game, player)

  @tailrec
  def play(game: Game, player: Player): Unit = {
    println()
    println(game.state)
    println()

    if (! game.state.gameOver) {
      player.decide(game.state.board) match {
        case move: Move => play(game.move(move), player)
        case Quit => println("You quitter!")
        case Undo => ???
      }
    } else {
      println("GAME OVER")
    }
  }
}
