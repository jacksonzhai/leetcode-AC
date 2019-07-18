package program.scala.program.scala.extend

trait  RadioativeBeef extends AbstractCurrency
class NiceTry(val curr:RadioativeBeef) extends Economy {
  override type Currency = RadioativeBeef
}
