package com.commandlinegirl.linalg

/**
  * Utility object for basic operations on vectors.
  */
object VectorOp {

  def normalize(v: Array[Double]): Option[Array[Double]] = {
    val n = norm(v)
    try {
      Option(v map (_ / n))
    } catch {
      case e: ArithmeticException => None
    }
  }

  def norm(v: Array[Double]): Double =
    Math.sqrt(v map (x => x * x) sum)

  def dot(v1: Array[Double], v2: Array[Double]): Double = {
    (v1 zip v2) map (x => x._1 * x._2) sum
  }

  def multiply(n: Double, v: Array[Double]): Array[Double] =
    v map (_ * n)

  def subtract(v1: Array[Double], v2: Array[Double]): Array[Double] =
    (v1 zip v2) map (x => x._1 - x._2)
}
