package program.scala.compose

class ArrayElement(conts:Array[String]) extends  Element {
  def contents:Array[String] = conts

  override def demo(): Unit = {
    println("ArrayElement's implementation invoked")
  }

}
