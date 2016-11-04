package com.commandlinegirl.linalg.test.datastructures

import com.commandlinegirl.linalg.datastructures.SimpleMatrix
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit._

@RunWith(classOf[JUnitRunner])
class SimpleMatrixTest extends FunSuite {

  test("sum") {
    val a = new SimpleMatrix(List(List(1,2), List(3,4)))
    assert(a.sum == 10)
  }

  test("transpose") {
    val a = new SimpleMatrix(List(List(1,2), List(3,4)))
    assert(a.transpose == new SimpleMatrix(List(List(1,3),List(2,4))))
  }

  test("multiplication") {
    val a = new SimpleMatrix(List(List(1.0,2.0), List(3.0,4.0)))
    val b = new SimpleMatrix(List(List(0,5),List(6,7)))
    assert(a * b == new SimpleMatrix(List(List(12, 19),List(24, 43))))
  }

  test("scalar multiplication") {
    val a = new SimpleMatrix(List(List(1.0,2.0), List(3.0,4.0)))
    val scalar = 5
    assert(a * scalar == new SimpleMatrix(List(List(5, 10),List(15, 20))))
  }
}