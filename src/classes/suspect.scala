package classes

/**
 * Created by lwald_000 on 10/26/2015.
 */
class Suspect(nameIn : String = null) {

  var name : String = null

  if (nameIn == null) {
     name = generateName()
  }else name = nameIn
  var isPerp : Boolean = false


  def generateName(): String ={
    val alphabet =  "abcdefghijklmnopqrstuvwxyz0123456789"
    Stream.continually(scala.util.Random.nextInt(alphabet.length)).map(alphabet).take(4).mkString
  }

}
