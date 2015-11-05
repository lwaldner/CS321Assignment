package traits

import classes.Suspect

/**
 * Created by lwald_000 on 10/29/2015.
 */
trait LogicTrait {

  var suspects: Array[Suspect]

  def initalizeSuspects()

  def checkGuess(guess: List[Suspect]) : Boolean

  def getLineUp() : Tuple2[Int, Array[Suspect]]

}
