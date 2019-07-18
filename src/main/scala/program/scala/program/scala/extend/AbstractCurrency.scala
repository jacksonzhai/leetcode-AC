package program.scala.program.scala.extend

trait AbstractCurrency {
  def disappearInGreece():Unit

}
abstract class Economy {
  type Currency <: AbstractCurrency

  def curr: Currency

  // can call disappear... because `Currency`
  // is an `AbstractCurrency`
  def shake(): Unit = curr.disappearInGreece()
}
