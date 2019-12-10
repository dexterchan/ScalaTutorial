package animals

import net.liftweb.util.Helpers._
import net.liftweb.json._

object Run extends App {
  implicit val formats = DefaultFormats

  val myCat = new Cat("Sensemaya", "Tabby")
  val myDog = new Dog("Hatshepsut", "Puggle")

  println("I'm running really well! " + capify(myCat.speak) + " " + capify(myDog.speak))
  println("This is my cat and dog as JSON:")
  println(prettyRender(Extraction.decompose(myCat)))
  println(prettyRender(Extraction.decompose(myDog)))
}
