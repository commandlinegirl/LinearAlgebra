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
  
}