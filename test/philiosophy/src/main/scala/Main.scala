object Main extends App {
  println(s"Hello, World! ${addMany(10,20,30)}")

  println (s"describe nujmber of bits:${describeNumberOfBits(8)}")
  println (s"describe nujmber of bits:${describeNumberOfBitsMatch(1024)}")

  println (s"Demo option string with Some value: ${optionString(Some("Cat"))}")
  println (s"Demo option string None: ${optionString(None)}")

  println(s"Demo Option of else: ${OptionOrElse()}")

  def add(first: Int, second: Int): Int = {
     first+second
  };

  def addMany(numbers: Int*):Int={
      numbers.reduce( _+_)
  };

  def describeNumberOfBits(number: Int):String={
      if(number < 4){
          "bit"
      }else if(number<8){
          "nibble"
      }else if(number < 1023){
        "byte"
      }else{
        "many bytes"
      }
  }

  def describeNumberOfBitsMatch(number : Int): String={
    number match{
      case bit if bit < 4 => "bit"
      case nibble if nibble <8 => "nibble"
      case byte if byte < 1023 => "byte"
      case manybute => "manybyte"
    }
  }

  def optionString(myClosestAlly: Option[String]):String={
    //var myClosestAlly:Option[String] = Some(value)
    myClosestAlly match{
      case Some(person) => (s"I love ${person}")
      case None => ("No one came to see me")
    }
  }

  def OptionOrElse():String ={
    var myCloestAlly:Option[String] = None
    var myPet:Option[String] = None

    var myDanceFriend = myCloestAlly orElse myPet getOrElse "myself"

    println(s"Dance Friend:${myDanceFriend}")
    myCloestAlly = Some("apple")
    myDanceFriend = myCloestAlly orElse myPet getOrElse "myself"

    myDanceFriend
  }
}

