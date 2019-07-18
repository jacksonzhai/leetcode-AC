package program.scala.compose

class LineElement(s:String) extends Element {
  override def contents: Array[String] = Array(s)

  override def height: Int = 1

  override def width: Int = s.length

  override def demo(): Unit = {
    println("LineElement's implemention invoked")

  }

}
