package com.commandlinegirl.linalg.test

import com.commandlinegirl.linalg.{SimpleMatrix, QR}
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class QRTest extends FunSuite {

  test("gram schmidt modified") {
    val a = new SimpleMatrix(Array(Array(1, 1, 1), Array(1, 0 , 2)))
    val expQ = new SimpleMatrix(Array(
      Array(1 / math.sqrt(3), 1 / math.sqrt(3), 1 / math.sqrt(3)),
      Array(0, -1 / math.sqrt(2), 1/math.sqrt(2))
    ))
    val expR = new SimpleMatrix(Array(
      Array(1 / math.sqrt(3), 1 / math.sqrt(3), 1 / math.sqrt(3)),
      Array(1 / math.sqrt(3) - 1 / math.sqrt(2), 1 / math.sqrt(3), 1 / math.sqrt(3) - 2 / math.sqrt(2)),
      Array(1 / math.sqrt(3) + 1 / math.sqrt(2), 1 / math.sqrt(3), 1 / math.sqrt(3) + 2 / math.sqrt(2))
    ))
    val result = QR.gramSchmidtModified(a)
    assert(result._1 == expQ)
    assert(result._2 == expR)
  }



}