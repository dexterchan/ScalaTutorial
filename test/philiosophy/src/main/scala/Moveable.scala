trait Moveable  {
  var placeCount = 0
  def incrementPlaceCount: Unit = placeCount += 1
  var place:String
  def moveTo(place:String): Unit

}
