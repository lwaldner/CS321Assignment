package objects

import classes.{Suspect, Player, Logic}

/**
 * Created by lwald_000 on 10/26/2015.
 */
object main {
  def yesNoInput(input: Any): Boolean = input match {
    case 'y' => true
    case 'n' => false

      throw new IllegalArgumentException
  }

  def parseGuess(guess: String): Array[Suspect] = {
    val size = guess.split(",").length
    if (size > 3) {
      throw new IllegalArgumentException
    }
    val temp = guess.split(",")
    val output = Array.fill[Suspect](temp.length)(null)
    for (i  <- 0 to temp.length-1){
      output(i) = new Suspect(temp(i))
    }
    //Array.fill[Suspect](temp.length)(new Suspect(temp.next()))
    output
  }

  def main(args: Array[String]): Unit = {
    println("Hello")
    //ask user for number of players
    val numPlayers = 3
    val players = Array.fill[Player](numPlayers)(new Player())
    /*for (i <- 1 to numPlayers) {
      players :+ new Player
    }*/
    Logic.initalizeSuspects()
    while (true) {
      val lineup = Logic.getLineUp()
      val numPerps = lineup._1
      val suspects = lineup._2
      //print suspects and number of perps
      println(s"number of perps ${numPerps}:")
      print(s"suspects are: ")
      suspects.foreach(s => print(s + " "))
      print("\n")
      for (p <- players if p.isPlaying) {
        //ask player if they want to guess
        print("would you like to guess? (y/n): ")
        val willGuess = scala.io.StdIn.readChar()
        println()
        if (yesNoInput(willGuess)) {
          print("enter your guesses seperated by commas: ")
          val input = scala.io.StdIn.readLine()
          println
          val guess = parseGuess(input)
          if (Logic.checkGuess(guess)) {
            println("you won!!!!")
          } else {
            println("you lost")
            p.isPlaying = false
          }
        }
      }
    }
  }
}
