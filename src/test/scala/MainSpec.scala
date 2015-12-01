import org.scalatest._
import sirens.Main._

class MainSpec extends FlatSpec with Matchers {

  val sirens = parseSirens(readFile("/sirens_fxt.txt"))

  "A non existent Sirens" should "be not found" in {
    sirens.get("999999999999999") should be (None)
  }

  "An existent Sirens with 1 occurrence" should "be found with 1" in {
    sirens.get("005520242") should be (Some(1))
  }

  "An existent Sirens with 2 occurrences" should "be found with 2" in {
    sirens.get("005541552") should be (Some(2))
  }

  "An existent Sirens with 32 occurrences" should "be found with 32" in {
    sirens.get("177501517") should be (Some(32))
  }

  "Number of Sirens which are present twice or more" should "be 2256" in {
    sirens.count(_._2 >= 2) should be (2256)
  }

  "Number of Sirens which are present only once" should "be 77445" in {
    sirens.count(_._2 == 1) should be (77445)
  }

}