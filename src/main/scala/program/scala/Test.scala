package program.scala

import java.io.{File, PrintWriter}

object Test {
  def f():Int = try return 1 finally return 2
  def g():Int = try 1 finally  2
  def fileLines(file:java.io.File) = scala.io.Source.fromFile(file).getLines()
  def main(args: Array[String]): Unit = {
    val filesHere = (new File(".")).listFiles()
    for(file <-filesHere
        if file.isFile
    ){
      println(file)
    }
    for(i <- 1 until 4) {
      println(i)
    }
    println(f)
    println(g)

  println(multiTable())

    withPrintWriter(
      new File("pom.xml"),writer=>writer.println(new java.util.Date())
    )
  }
def makeRowSeq(row:Int) ={
  for(col<- 1 until 10) yield {
    val prod = (row*col).toString
    val padding = " "*(4-prod.length)
    padding+prod
  }
}
  def makeRow(row:Int) = makeRowSeq(row).mkString
  def multiTable() = {
    val tableSeq = for (row <- 1 until 10) yield {
      makeRow(row)

    }
    tableSeq.mkString("\n")
  }

  def twice(op:Double=>Double,x:Double) = op(op(x))

  def withPrintWriter(file:File,op:PrintWriter => Unit) ={
    val  writer = new PrintWriter(file)
    try{
      op(writer)
    }finally {
      writer.close()
    }
  }
  withPrintWriter(
    new File(""),writer=>writer.println(new java.util.Date() + "Init in test")

  )


}
