package objects

import classes.{Suspect, Player, Logic}

/**
 * Created by lwald_000 on 10/26/2015.
 */
object main {
  def yesNoInput(input: Any): Boolean = input match {
    case 'y' => true
    case 'n' => false
    case _ => throw new IllegalArgumentException
  }

  def parseGuess(guess: String): Array[Suspect] = {
    val size = guess.split(",").length
    if (size > 3 || size < 3) {
      throw new IllegalArgumentException
    }
    val temp = guess.split(",")
    val output = Array.fill[Suspect](temp.length)(null)
    for (i  <- 0 to temp.length-1){
      output(i) = new Suspect(temp(i))
    }
    output
  }

  def getGuess() : Array[Suspect] = {
    print("enter your guesses seperated by commas: ")
    val input = scala.io.StdIn.readLine()
    println
    try {
      parseGuess(input)
    }catch {
      case e : Exception => getGuess()
    }
  }

  def main(args: Array[String]): Unit = {
    println("Hello")
    println("How many players?")
    val numPlayers = scala.io.StdIn.readInt()
    val players = Array.fill[Player](numPlayers)(new Player())
    Logic.initalizeSuspects()
    var isPlaying = true
    while (isPlaying) {
      val lineup = Logic.getLineUp()
      val numPerps = lineup._1
      val suspects = lineup._2
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
          val guess = getGuess()
          if (Logic.checkGuess(guess)) {
            println("you won!!!!")
            isPlaying = false
          } else {
            println("you lost")
            p.isPlaying = false
            var checkPlay = false
            for (p <- players){
              if (p.isPlaying) checkPlay = true
            }
            isPlaying = checkPlay
          }
        }
      }
    }
  }
}
