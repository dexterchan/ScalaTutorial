case class ModernFamily (val name: String, override val people: Seq[Person]) extends AbstractFamily(people) {
  def description(): String = {
    s"[${people.mkString(",")}]"
  }
  def descriptionModern()={
    s"$name : [${people.mkString(",")}] :"
  }
}
