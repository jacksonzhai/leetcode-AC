package program.scala.program.scala.extend.UTB

 abstract  class Animal {
def name:String
}
abstract class Pet extends Animal {}
class Cat extends Pet {
  override def name: String = "Cat"
}
class Dog extends Pet{
  override def name: String = "dog"
}
class Lion extends Animal{
  override def name: String = "lion"
}
class PetContainer[P <: Pet](p:P){
  def pet : P = p
}