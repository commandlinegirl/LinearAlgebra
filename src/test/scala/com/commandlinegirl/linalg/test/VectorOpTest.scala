package com.commandlinegirl.linalg.test

import com.commandlinegirl.linalg.VectorOp
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class VectorOpTest extends FunSuite {

  test("vector dot product") {
    val v1 = Array[Double](1.0, 1.0, 1.0)
    val v2 = Array[Double](1.0, 0.0, 2.0)
    assert(VectorOp.dot(v1, v2) == 3)
  }

  test("vector norm") {
    val v1 = Array[Double](4, 3)
    assert(VectorOp.norm(v1) == 5)
  }

  test("vector normalize") {
    val v1 = Array[Double](1.0, 1.0, 1.0)
    val v2 = Array[Double](1.0, 0.0, 2.0)
    assert(VectorOp.dot(v1, v2) == 3)
  }

  test("vector multiply") {
    val v = Array[Double](1.0, 0.0, 2.0)
    assert(VectorOp.multiply(5, v) sameElements Array(5, 0, 10))
  }

  test("vector subtract") {
    val v1 = Array[Double](1.0, 1.0, 1.0)
    val v2 = Array[Double](1.0, 0.0, 2.0)
    assert(VectorOp.subtract(v1, v2) sameElements Array(0, 1, -1))
  }
}
