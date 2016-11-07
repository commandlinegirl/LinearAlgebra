package com.commandlinegirl.linalg

import java.lang.Double.doubleToLongBits

/**
  * Utility object for basic operations on fields and vectors.
  */
object MathUtils {

  /**
    * Basic operations on a vector represented as an array.
    * @param v
    */
  implicit class VectorOp(v: Array[Double]) {

    def normalize: Option[Array[Double]] = {
      val n = v.norm
      try {
        Option(v map (_ / n))
      } catch {
        case e: ArithmeticException => None
      }
    }

    def norm: Double =
      Math.sqrt(v map (x => x * x) sum)

    def dot(v2: Array[Double]): Double = {
      (v zip v2) map (x => x._1 * x._2) sum
    }

    def *(n: Double): Array[Double] =
      v map (_ * n)

    def -(v2: Array[Double]): Array[Double] =
      (v zip v2) map (x => x._1 - x._2)
  }

  /**
    * Basic mathematical operations.
    * @param a
    */
  implicit class MathOp(a: Double) {

    def ~=(b: Double, precision: Double): Boolean =
      (a - b).abs <= precision

    def nearEqualDouble(b: Double): Boolean =
      a ~= (b, 0.1E-4)

  }

}


