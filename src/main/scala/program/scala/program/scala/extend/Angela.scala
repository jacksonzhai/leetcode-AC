package program.scala.program.scala.extend

trait  Euro extends AbstractCurrency
class Angela(val curr:Euro) extends Economy {
  override type Currency = Euro
}
