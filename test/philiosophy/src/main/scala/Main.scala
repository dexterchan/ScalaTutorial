
object Main extends App {
  println(s"Hello, World! ${addMany(10,20,30)}")

  println (s"describe nujmber of bits:${describeNumberOfBits(8)}")
  println (s"describe nujmber of bits:${describeNumberOfBitsMatch(1024)}")

  println (s"Demo option string with Some value: ${optionString(Some("Cat"))}")
  println (s"Demo option string None: ${optionString(None)}")

  println(s"Demo Option of else: ${OptionOrElse()}")

  BasicCollection()

  testComprehension()

  test_GenericCollection()
  basicOO()

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

  def BasicCollection()={
    var fileSizes:Seq[Int] = List(1024, 2048, 50, 900, 6500)
    fileSizes.foreach(fileSize => print(fileSize+","))
    println()

    var fileSizeSum=0
   fileSizes.foreach(fileSize=>fileSizeSum+=fileSize)
    println(s"Sum of file size: ${fileSizeSum}")

    //nasty double size by operator :+=
    var doubleFileSizes = Seq[Int]()
    fileSizes.foreach(fileSize=>doubleFileSizes:+=fileSize*2)

    doubleFileSizes = fileSizes.map(fileSize => 2*fileSize)
    println(doubleFileSizes)

    var fileSizeDes = fileSizes.map(fileSize=>s"File size is ${fileSize}")
    println(fileSizeDes)

    var filteredFileSize = fileSizes.filter(fileSize => fileSize > 1000)
    println(filteredFileSize)

    filteredFileSize = fileSizes.filter(_ > 1000)
    println(filteredFileSize)

    var findFileSize = fileSizes.find(_>1024)
    println(s"Found fileSize > 1024 ${findFileSize}")

    findFileSize = fileSizes.find(_<1)
    println(s"Found fileSize < 1 ${findFileSize}")

    findFileSize = fileSizes.find(_>100000) orElse fileSizes.find(_>6000)
    println(s"Found fileSize > 100000 or > 6000 ${findFileSize}")

    var fileSizeComment = fileSizes.map{
      case kilo  if kilo>=1024 => s"This file is ${kilo/1024}Kb"
      case byte  if byte<1024 => s"This file is ${byte}byte"
    }
    println(fileSizeComment)
  }

  def testComprehension()={
      val antonio = Person("Antonio", 40)
      val mary = Person ("Mary", 40)
      val cleo = Person ("Cleo", 16)
      val santiago = Person("Santiago", 12)
      val family1 = Family(Seq[Person](antonio, mary, cleo, santiago))
      val sam = Person("Sam", 40)
      val sandy = Person ("Sandy", 40)
      val alan = Person ("Alan", 16)
      val family2 = Family(Seq[Person](sam, sandy, alan))
      val families = Seq[Family](family1, family2)
      println(family1.people.map(_.name))
      println(families.map(_.people.map(_.name)))
      println(families.map(_.people.map(_.name)).flatten)
      println(families.flatMap(_.people.map(_.name)))
      println(families.flatMap(_.people.filter(_.age>18).map(_.name)))

    var comprehension = for{
      family<-families.filter(_.people.exists(_.age>=30))
      person <- family.people
      isAdult =  person.age>=18
      if isAdult
    }yield{
      person.name
    }
    println("Filter with comprehension:"+comprehension)

    comprehension = for{
      family<-families.find(_.people.exists(_.age>=30)).toSeq
      person <- family.people
      isAdult =  person.age>=18
      if isAdult
    }yield{
      person.name
    }
    println("Find with comprehension (option):"+comprehension)
  }

  def test_GenericCollection()={
    val numbers = Seq(1,2,3,4,5)
    val result = numbers.reduce{ (a,b) => println(s"${a},${b}");a+b }
    println(s"Reduce result: ${result}")

    val foldString = numbers.foldLeft(""){(accumString, number)=> accumString+","+number}
    println(s"FoldLeft String result: ${foldString}")

    var foldList = numbers.foldLeft(Seq[Int]()){(l: Seq[Int], number:Int)=> l :+ number}
    println (s"FoldLeft for sequence: ${foldList}")

    foldList = numbers.foldLeft(Seq[Int]()){(l: Seq[Int], number:Int)=>
      val lastSum = l.lastOption getOrElse 0
      l :+ (lastSum + number)
    }
    println (s"FoldLeft for sequence: ${foldList}")

    val antonio = Person("Antonio", 40)
    val mary = Person ("Mary", 40)
    val cleo = Person ("Cleo", 16)
    val santiago = Person("Santiago", 12)
    val family = Family(Seq[Person](antonio, mary, cleo, santiago))

    val familyVersions = family.people.foldLeft(Seq[Family]()){
      (familyVersions:Seq[Family], person:Person)=>
        val latestVersion = familyVersions.lastOption
        val lastPeopleGrp = latestVersion.map(_.people) getOrElse(Seq[Person]())
        familyVersions :+ Family(lastPeopleGrp :+ person)
    }
    println(s"Evolving family version: ${familyVersions}")

    var r = numbers.foldLeft(Seq[Int]()) (_ :+ _)
    r = numbers.foldLeft(Seq[Int]()){(l: Seq[Int], number:Int)=> l :+ number}
    println (s"FoldLeft short: ${r}")
    var reverseResult = numbers.foldRight(Seq[Int]())( _ +: _)
    reverseResult = numbers.foldRight(Seq[Int]()){(number:Int, l:Seq[Int])=> number +: l}
    println(s"FoldRight short: ${reverseResult}")

  }

  def basicOO()={
    var group = Group("Fruit", Seq[String]("apple","orange"))
    println(group.description)
    println (group.descriptionVal)

    group = Group("Vegetable", Seq[String]("lettuce","spinach"))
    println(group.description)
    println (group.descriptionVal)

    val antonio = Person("Antonio", 40)
    val mary = Person ("Mary", 40)
    val cleo = Person ("Cleo", 16)
    val santiago = Person("Santiago", 12)
    val family = Family(Seq[Person](antonio, mary, cleo, santiago))
    val modernFamily = ModernFamily("AM family", Seq[Person](antonio, mary, cleo, santiago))
    println(modernFamily.description);
    println(modernFamily.descriptionModern);

    val pp:Namable = Person("pigpig", 10)
    println(pp)
    val pet:Pet = Pet("cat", "wanchai")
    println(pet)
    println(pet.latestPlace)
    pet.moveTo("central")
    println(pet)
    println(pet.latestPlace)
    println(s"Pet is Placeable:${pet.isInstanceOf[Placeable] }")

    var peopleSingleton = PeopleSingleton
    println (peopleSingleton.allPeople)
    peopleSingleton.addPerson(antonio)
    println(peopleSingleton.allPeople)

    var antonio41=Person.withAge(antonio, 41)
    println(s"${antonio} -> ${antonio41}")
    var baby = Person.apply("baby")
    println(s"${baby}")

  }
}


