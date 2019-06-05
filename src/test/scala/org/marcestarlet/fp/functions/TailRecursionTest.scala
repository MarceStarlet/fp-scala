package org.marcestarlet.fp.functions

import org.scalatest.{FlatSpec}

class TailRecursionTest extends FlatSpec {

  behavior of "TailRecursionTest"

  "A factorial function of 7" should "return 5040" in {
    assert(TailRecursion.factorial(7) == 5040)
  }

  "A fib function of 0" should "return 0" in {
    assert(TailRecursion.fib(0) == 0)
  }

  "A fib function of 1" should "return 1" in {
    assert(TailRecursion.fib(1) == 1)
  }

  "A fib function of 7" should "return 13" in {
    assert(TailRecursion.fib(7) == 13)
  }

  "A fib function of 9" should "return 34" in {
    assert(TailRecursion.fib(9) == 34)
  }
}
