case class Person( override val name: String, age: Int) extends Namable {

}

case object Person {
  def apply(name: String):Person = new Person(name, 0)
  def withAge(person:Person, newAge: Int): Person = new Person(person.name, newAge)
}