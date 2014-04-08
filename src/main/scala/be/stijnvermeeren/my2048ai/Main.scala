package be.stijnvermeeren.my2048ai

import be.stijnvermeeren.my2048ai.player.{Random, MovePriority, Player, Human}

object Main extends App {
  val player = Random()
  benchmark(player)

  def singleGame(player: Player): GameResult = {
    val result = new GameResult(player)
    result.log()
    result
  }

  def benchmark(player: Player, tries: Int = 100): Unit = {
    val data = for (i <- 0 until tries) yield {
      val result = new GameResult(player)
      result.log()
      (result.score, result.maxValue)
    }
    val (scores, maxValues) = data.unzip

    println(s"Tries: $tries")
    println(s"Top score: ${scores.max}")
    println(f"Average score: ${scores.sum.toDouble / tries}")
    println(s"Top max value: ${maxValues.max}")
    val frequencies = maxValues.groupBy(value => value).mapValues(_.size.toDouble / tries).toList.sortBy(_._1).reverse
    println(s"Max value frequencies: $frequencies")
  }
}
