package be.stijnvermeeren.my2048ai

import be.stijnvermeeren.my2048ai.game.Game
import be.stijnvermeeren.my2048ai.move.{Undo, Quit, Move}
import be.stijnvermeeren.my2048ai.player.Player
import scala.annotation.tailrec
import java.io.File
import java.util.Date

class GameResult(player: Player) {
  val start = Game.start()
  val game = GameResult.play(start, player)

  lazy val maxValue: Int = game.state.board.maxValue
  lazy val score: Int = game.state.score

  val format = new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS")
  val timestamp = format.format(new Date()) + "-" + (System.nanoTime % 1000000)
  lazy val defaultLogName = s"${timestamp}_score-${score}_maxValue-$maxValue"

  def log(name: String = defaultLogName) = {
    val p = new java.io.PrintWriter(new File(s"logs/$name.log"))
    try {
      game.fullHistory.reverse foreach p.println
    } finally {
      p.close()
    }
  }
}

object GameResult {
  @tailrec
  def play(game: Game, player: Player): Game = {
    player.tell(game.state.toString)

    if (! game.state.gameOver) {
      player.decide(game.state.board) match {
        case move: Move => play(game.move(move), player)
        case Quit =>
          player.tell("You quitter!")
          game
        case Undo => ???
      }
    } else {
      player.tell("GAME OVER")
      game
    }
  }
}