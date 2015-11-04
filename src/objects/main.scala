package objects

import classes.Player

/**
 * Created by lwald_000 on 10/26/2015.
 */
object main {

  def main (args: Array[String]): Unit = {
    println("Hello")
    val numPlayers = 3
    val players = List[Player]()
    for (i <- 1 to numPlayers) {
      players :+ new Player
    }
  }

}
