package objects

import classes.{Suspect, Player}
import scala.io.StdIn
import traits.Logic

/**
 * Created by lwald_000 on 10/26/2015.
 */
object main {
  def yesNoInput (input: Any): Boolean = input match {
      case 'y' => true
      case 'n' => false
      _ => UnknownError
  }
  def main (args: Array[String]): Unit = {
    println("Hello")
    //ask user for number of players
    val numPlayers = 3
    val players = List[Player]()
    for (i <- 1 to numPlayers) {
      players :+ new Player
    }
    var game = new Logic
    game.initalizePerps()
    while (true) {
      val lineup = game.getLineUp()
      val numPerps = lineup._1
      val suspects = lineup._2
      //print suspects and number of perps
      for (p <- players if p.isPlaying; ) {
        //ask player if they want to guess
        print("would you like to guess? (y/n): ")
        val willGuess = scala.io.StdIn.readChar()
        if(YesNoInput(willGuess)){
        //get guess
          val guess = List[Suspect]()
          if (game.checkGuess(guess)) {
            //player wins!
          } else {
            //player loses :(
            p.isPlaying = false
          }
        }//willguess
      }
    }
  }

}
