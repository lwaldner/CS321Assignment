package classes

import traits.LogicTrait
import classes.Suspect

/**
 * Created by lwald_000 on 11/2/2015.
 */

  object Logic extends LogicTrait{

    val r = scala.util.Random
    var suspects : Array[Suspect] = Array.fill[Suspect](7)(new Suspect())

    def initalizeSuspects() : Unit = {
      val perps = getRandUnique(3, 6)
      for (i <- perps){
        suspects(i).isPerp = true
      }
    }

    def checkGuess(guess : Array[Suspect]) : Boolean = {
      val perps = suspects.filter(_.isPerp)
      for (s <- guess) {
        for (p <- perps) {
          if (s.name == p.name && p.isPerp) {
            p.isPerp = false
          }
        }
      }
      !perps.exists(_.isPerp)
      /*for (suspect <- suspects){
        for (s <- guess){

          if (s.name == suspect.name && !suspect.isPerp) false
        }
      }
      true*/
    }

    def getLineUp() : Tuple2[Int, Array[String]] = {
      val perps = getRandUnique(3, 6)
      val lineUp = Array[String](suspects(perps(0)).name, suspects(perps(1)).name, suspects(perps(2)).name)
      var numPerps = 0
      for (i <- perps){
        if (suspects(i).isPerp){
          numPerps+=1
        }
      }
      new Tuple2[Int, Array[String]](numPerps, lineUp)
    }

    def getRandUnique(numNums : Int, range : Int) : Array[Int] = {
      val output = Array.fill(numNums)(0)
      for (i <- 0 to (numNums - 1)){
        var num = r.nextInt(range)
        while (output.contains(num)){
          num = r.nextInt(range)
        }
        output(i) = num
      }
      output
    }


}