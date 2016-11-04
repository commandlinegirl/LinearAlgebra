package com.commandlinegirl.linalg.test

import com.commandlinegirl.linalg.GaussianElimination
import com.commandlinegirl.linalg.datastructures.SimpleMatrix
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GaussianEliminationTest extends FunSuite {

  test("gaussian") {
    val a = new SimpleMatrix(Array(Array(1, -1, 0), Array(-1, 2, -1), Array(0, -1, 2)))
    val exp = new SimpleMatrix(Array(Array(1, -1, 0), Array(0, 1, -1), Array(0, 0, 1)))
    assert(GaussianElimination.gauss(a) == exp)
  }

  test("gaussian with zero initial pivot") {
    val a = new SimpleMatrix(Array(Array(0, 2, 4), Array(3, 2, 5)))
    val exp = new SimpleMatrix(Array(Array(3, 2, 5), Array(0, 2, 4)))
    val result = GaussianElimination.gauss(a)
    println(result)
    assert(result == exp)
  }

}