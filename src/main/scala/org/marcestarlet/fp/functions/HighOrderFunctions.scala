package org.marcestarlet.fp.functions

import scala.annotation.tailrec

/**
  * High Order functions examples
  * A HOF is a function which can receive other functions as arguments
  */
object HighOrderFunctions {

  // monomorphic functions, only works for specific types (e.g. Int, String, MyType)

  /**
    * The formatResult functions is a High Order functions, it receives a function as an argument and applies it
    * inside. Common tend in functional programming is call the HOFs with simple letters (e.g. f,h,g) due to they are
    * so general that do not need to describe more than what they represent.
    *
    * @param name the function name to apply
    * @param n the value to apply to the f function
    * @param f the Int => Int function (e.g. factorial, fibonacci)
    * @return string format
    */
  def formatResult(name: String, n:Int, f: Int => Int):String = {
    s"The ${name} of ${n} is ${f(n)}"
    //println(msg)
  }

  // polymorphic functions, do work for different types (e.g. A a generic type)

  /**
    * finds the first element in an Array[A] that matches function p
    */
  def findFirst[A](array: Array[A], p: A => Boolean): Int = {
    @tailrec
    def loop(n: Int):Int = {
      if (n >= array.length) -1
      else if (p(array(n))) n
      else loop( n + 1)
    }
    loop(0)
  }

  /**
    * checks if an Array[A] is sorted by matching the ordered function
    */
  def isSorted[A](array: Array[A], ordered:(A,A) => Boolean): Boolean = {
    @tailrec
    def loop(n: Int): Boolean = {
      if (n == (array.length - 1)) true
      else if (ordered(array(n), array(n + 1))) loop(n + 1)
      else false
    }
    loop(0)
  }

  // partial application functions

  /**
    * Do only can be written in one way.
    * Converts a function of two arguments and returns a function of one argument
    * partial, is a function of 2 arguments (a value and a f function of 2 arguments) which in fact partially applies f,
    * only one of its arguments.
    */
  def partial[A,B,C](a: A, f: (A,B) => C): B => C = {
    b => f(a,b)
  }

  // iso-morphic functions (same form)

  /**
    * Converts a function of 2 arguments into a function of one and partially applies f
    */
  def curry[A,B,C](f: (A,B) => C ): A => (B => C) = {
    a => b => f(a,b)
  }

  /**
    * The inverse of curry, converts a function of one argument into a function of two arguments and partially applies f
    */
  def uncurry[A,B,C](f: A => B => C): (A,B) => C = {
    (a,b) => f(a)(b)
  }

  // compose functions

  /**
    * Compose a function f with g, the output of g is the input of f.
    * Sometimes called 'g andThen f', to specify the continuity of results between both functions
    */
  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    a => f(g(a))
  }
}
