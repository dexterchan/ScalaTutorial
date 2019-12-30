case class Family(people: Seq[Person]) {
  def description: String = {
    s"[${people.mkString(",")}]"
  }
}
