package org.marcestarlet.fp.functions

import scala.annotation.tailrec

object TailRecursion {

  /**
    * The factorial function is a tail recursive function, since the function returns no more than the result value
    * of the function. In other words, a function is in "tail position" if do not apply other operations to the result
    * value of the function (e.g. 1 + f(1, n) is not in tail position since needs to add 1 to the result).
    *
    * For Scala this means that the compiler will transform it to a while loop in bytecode to avoid call stack consumption.
    * @param n nth factorial wanted
    * @return factorial number
    */
  def factorial(n: Int):Int = {
    @tailrec // explicit specification of a tail recursion for the compiler
    def loop(n: Int, acc: Int):Int = {
      if (n <= 1) acc
      else loop(n-1, n * acc)
    }

    loop(n, 1)
  }

  /**
    * The fib function is a tail recursive function for the Fibonacci serie, since the local loop function is only
    * returning as a result the value of itself call, so it is in tail position.
    *
    * The recursive call fib(n-1) + fib(n-2) to calculate the Fibonacci serie, isn't a tail recursive function
    * due to is doing an addition operation of the result of each fib function result, so does not match the definition
    * of a tail recursive.
    *
    * @param n nth Fibonacci serie wanted
    * @return Fibonacci number
    */
  def fib(n: Int):Int = {
    @tailrec
    def loop(n: Int, prev: Int, sum: Int): Int = {
      if (n == 0 ) prev
      else if (n == 1) sum
      else loop(n - 1, sum, prev + sum)
    }

    loop(n, 0, 1)
  }

}
