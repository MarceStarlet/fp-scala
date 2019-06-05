package org.marcestarlet.fp.functions

import org.scalatest.FlatSpec

class HighOrderFunctionsTest extends FlatSpec {

  behavior of "HighOrderFunctionsTest"

  "A formatResult function of factorial of 7" should "formats to" in {
    assert(HighOrderFunctions.formatResult("factorial", 7, TailRecursion.factorial) == "The factorial of 7 is 5040")
  }

  "A formatResult function of fibonacci of 7" should "formats to" in {
    assert(HighOrderFunctions.formatResult("fibonacci", 7, TailRecursion.fib) == "The fibonacci of 7 is 13")
  }

  // testing polymorphic functions using anonymous functions passed as arguments

  "A findFirst function of Array(1,2,3)" should "return 2 when finding 3" in {
    assert(HighOrderFunctions.findFirst(Array(1,2,3), (x: Int) => x == 3) == 2)
  }

  "A isSorted function of Array(4,1,9)" should "return false" in {
    assert(HighOrderFunctions.isSorted(Array(4,1,9), (x: Int, y: Int) => x <= y ) == false)
  }

  "A isSorted function of Array(2,6,9)" should "return true" in {
    assert(HighOrderFunctions.isSorted(Array(2,6,9), (x: Int, y: Int) => x <= y ) == true)
  }

  "A isSorted function of Array('a','b','c')" should "return true" in {
    assert(HighOrderFunctions.isSorted(Array("a","b","c"), (x: String, y: String) => x <= y ) == true)
  }

}
