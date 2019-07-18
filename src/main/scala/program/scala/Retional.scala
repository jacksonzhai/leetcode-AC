package program.scala

class Retional(n: Int,d:Int){
  require(d!=0)
  private val g = gcd(n.abs,d.abs)
  val numer:Int = n/g
  val denom:Int = d/g

  def this(n:Int) = this(n,1)
  override def toString: String = numer+"/"+denom

  def add(that:Retional):Retional ={
    new Retional(numer*that.denom + that.numer*denom,denom*that.denom)
  }
  def lessThan(that:Retional) = {
    this.numer*that.denom<that.numer*this.denom
  }
  def max(that:Retional) = {
    if(this.lessThan(that)) that else this
  }
  private def gcd(a:Int,b:Int):Int = {
    if(b==0) a else gcd(b,a%b)
  }
  def +(that:Retional):Retional ={
    new Retional(numer*that.denom + that.numer*denom,denom*that.denom)
  }
  def *(that:Retional):Retional = {
    new Retional(numer*that.numer,denom*that.denom)
  }
  def +(i:Int):Retional = {
    new Retional(numer+i*denom,denom)
  }
  def *(i:Int):Retional ={
    new Retional(numer*i,denom)
  }
  def /(that:Retional):Retional = {
    new Retional(numer*that.denom,denom*that.numer)
  }
  def /(i:Int):Retional = {
    new Retional(numer,denom*i)
  }
  def -(that:Retional):Retional ={
    new Retional(numer*that.denom - that.numer*denom, denom*that.denom)

  }
  def -(i:Int):Retional ={
    new Retional(numer - i*denom,denom)
  }


}
