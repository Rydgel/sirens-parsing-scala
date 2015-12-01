package sirens


object Main {

  type Sirens = Map[String, Int]

  def parseSirens(s: String): Sirens = {
    // s.split("\n").groupBy(identity).mapValues(_.length) // slower imo
    s.split("\n").foldLeft(Map.empty: Sirens) { (z, bs) =>
      z.updated(bs, z.get(bs).map(_ + 1).getOrElse(1))
    }
  }

  def readFile(fp: String): String = {
    val stream = getClass.getResourceAsStream(fp)
    scala.io.Source.fromInputStream(stream).getLines().mkString("\n")
  }

  def main(args: Array[String]) {
    val fileStr = readFile("/sirens_fxt.txt")
    val sirens = parseSirens(fileStr)
    println("Number of Sirens which are present twice or more: ")
    println(sirens.count(_._2 >= 2))
    println("Number of Sirens which are present only once: ")
    println(sirens.count(_._2 == 1))
  }
}
