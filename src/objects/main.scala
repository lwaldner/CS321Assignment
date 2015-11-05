package objects

import classes.{Suspect, Player, Logic}

/**
 * Created by lwald_000 on 10/26/2015.
 */
object main {

  def main (args: Array[String]): Unit = {
    println("Hello")
    //ask user for number of players
    val numPlayers = 3
    val players = List[Player]()
    for (i <- 1 to numPlayers) {
      players :+ new Player
    }
    Logic.initalizePerps()
    while (true) {
      val lineup = Logic.getLineUp()
      val numPerps = lineup._1
      val suspects = lineup._2
      //print suspects and number of perps
      for (p <- players if p.isPlaying; ) {
        //ask player if they want to guess
        //get guess
        val guess = List[Suspect]()
        if (Logic.checkGuess(guess)) {
          //player wins!
        } else {
          //player loses :(
          p.isPlaying = false
        }
      }
    }
  }

}
