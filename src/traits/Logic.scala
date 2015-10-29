package traits

import classes.Suspect

/**
 * Created by lwald_000 on 10/29/2015.
 */
trait Logic {

  var suspects: Array[Suspect]

  def initalizePerps()

  def checkGuess(guess: Array[Suspect]) : Boolean

  def getLineUp() : Tuple2[Int, Array[Suspect]]

  

}
