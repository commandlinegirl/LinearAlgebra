package com.commandlinegirl.linalg

object MathOp {

  def ~=(a: Double, b: Double, precision: Double): Boolean =
    (a - b).abs <= precision
}
