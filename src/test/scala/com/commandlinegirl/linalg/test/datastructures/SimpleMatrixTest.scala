package com.commandlinegirl.linalg.test.datastructures

import com.commandlinegirl.linalg.datastructures.SimpleMatrix
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit._

@RunWith(classOf[JUnitRunner])
class SimpleMatrixTest extends FunSuite {

  test("sum") {
    val a = new SimpleMatrix(Array(Array(1,2), Array(3,4)))
    assert(a.sum == 10)
  }

  test("transpose") {
    val a = new SimpleMatrix(Array(Array(1,2), Array(3,4)))
    assert(a.transpose == new SimpleMatrix(Array(Array(1,3),Array(2,4))))
  }

  test("multiplication") {
    val a = new SimpleMatrix(Array(Array(1.0,2.0), Array(3.0,4.0)))
    val b = new SimpleMatrix(Array(Array(0,5),Array(6,7)))
    assert(a * b == new SimpleMatrix(Array(Array(12, 19),Array(24, 43))))
  }

  test("scalar multiplication") {
    val a = new SimpleMatrix(Array(Array(1.0,2.0), Array(3.0,4.0)))
    val scalar = 5
    assert(a * scalar == new SimpleMatrix(Array(Array(5, 10),Array(15, 20))))
  }
}