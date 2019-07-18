package program.scala.compose
import Eelement._
abstract class Element {
  def demo()={
    println("Element's implemention invoked")
  }
  def contents:Array[String]
  def height = contents.length
  def width  = if(height ==0) 0 else contents(0).length
  def above(that:Element) :Element ={
    val this1 = this widen that.width
    val that1 = that widen this.width

    elem(this1.contents ++ that1.contents)
  }
  def beside(that:Element):Element ={
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
    for(
      (line1,line2) <- this1.contents zip that1.contents
    )yield line1+line2
    )
  }

  override def toString: String = {
    contents mkString "\n"
  }
  def widen(w:Int): Element = {
    if(w<width) this
    else{
      val left = elem(' ',(w-width)/2,height)
      val right = elem(' ',w-width-left.width,height)
      left beside this beside right
    }
  }
  def heighten(h:Int) :Element ={
    if(h<=height) this
    else{
      val top = elem(' ',width,(h-height)/2)
      val bot = elem(' ',width,h-height-top.height)
      top above this above bot
    }
  }

}
object Eelement {

  def elem(contents: Array[String]): Element = {
    new ArrayElement(contents
    )
  }

  def elem(char: Char, width: Int, height: Int): Element = {
    new UniformElement(char, width, height)
  }

  def elem(line: String): Element = {
    new LineElement(line)
  }
}

