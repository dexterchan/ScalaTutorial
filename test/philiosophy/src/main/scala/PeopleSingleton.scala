case object PeopleSingleton {
  var allPeople: Seq[Person]  = Seq.empty
  def addPerson(person:Person) = {
    allPeople = allPeople :+ person
  }
}
