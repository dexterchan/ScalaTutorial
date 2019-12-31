case class Pet(val name: String, var place: String) extends Namable with Placeable with Moveable {
  //override def moveTo(newPlace: String): Unit = {
  //  this.place = newPlace
  //}
  override def moveTo(place:String): Unit = {
    this.place = place
    incrementPlaceCount
  }
  override def incrementPlaceCount: Unit = super.incrementPlaceCount
  def latestPlace:String = s"$place @ $placeCount"
}
