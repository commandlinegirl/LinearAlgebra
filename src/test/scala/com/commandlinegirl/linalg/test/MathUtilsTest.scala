package com.commandlinegirl.linalg.test

import com.commandlinegirl.linalg.MathUtils._

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MathUtilsTest extends FunSuite {

  test("vector dot product") {
    val v1 = Array[Double](1.0, 1.0, 1.0)
    val v2 = Array[Double](1.0, 0.0, 2.0)
    assert((v1 dot v2) == 3)
  }

  test("vector norm") {
    val v1 = Array[Double](4, 3)
    assert(v1.norm == 5)
  }

  test("vector normalize") {
    val v1 = Array[Double](1.0, 1.0, 1.0)
    val v2 = Array[Double](1.0, 0.0, 2.0)
    assert((v1 dot v2) == 3)
  }

  test("vector multiply") {
    val v = Array[Double](1.0, 0.0, 2.0)
    assert((v * 5) sameElements Array(5, 0, 10))
  }

  test("vector subtract") {
    val v1 = Array[Double](1.0, 1.0, 1.0)
    val v2 = Array[Double](1.0, 0.0, 2.0)
    assert(v1 - v2 sameElements Array(0, 1, -1))
  }
}
