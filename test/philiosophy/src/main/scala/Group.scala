case class Group (name: String, peopleName: Seq[String]) {
  private var descriptionCalls: Int = 0
  def description: String = {
    descriptionCalls += 1
    s"$name : [${peopleName.mkString(",")}] : $descriptionCalls"
  }
  val descriptionVal: String = {
    descriptionCalls += 1
    s"$name : [${peopleName.mkString(",")}] : $descriptionCalls"
  }
}
