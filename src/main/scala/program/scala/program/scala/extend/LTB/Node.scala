package program.scala.program.scala.extend.LTB

trait Node[+B] {
  def prepend[U >:B](elem:U):Node[U]

}
case class ListNode[+B](h:B,t:Node[B]) extends Node[B]{
  def prepend[U >: B](elem: U): ListNode[U] = ListNode(elem, this)
  def head:B =h
  def tail:Node[B] = t

}
case class Nil[+B]() extends Node[B] {
  override def prepend[U >: B](elem: U): ListNode[U] = ListNode(elem,this)
}
