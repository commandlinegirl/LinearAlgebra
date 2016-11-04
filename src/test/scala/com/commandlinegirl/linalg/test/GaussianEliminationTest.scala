package com.commandlinegirl.linalg.test

import com.commandlinegirl.linalg.GaussianElimination
import com.commandlinegirl.linalg.datastructures.SimpleMatrix
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GaussianEliminationTest extends FunSuite {

  test("gaussian") {
    val a = new SimpleMatrix(List(List(1, -1, 0), List(-1, 2, -1), List(0, -1, 2)))
    val exp = new SimpleMatrix(List(List(1, -1, 0), List(0, 1, -1), List(0, 0, 1)))
    assert(GaussianElimination.gauss(a) == exp)
  }

  test("gaussian with zero initial pivot") {
    val a = new SimpleMatrix(List(List(0, 2, 4), List(3, 2, 5)))
    val exp = new SimpleMatrix(List(List(3, 2, 5), List(0, 2, 4)))
    val result = GaussianElimination.gauss(a);
    println(result)
    assert(result == exp)
  }

}