package com.commandlinegirl.linalg.datastructures

class SimpleMatrix(val rowVectors : List[List[Double]]) extends Matrix {

  def rowCount = rowVectors.size
  def colCount = rowVectors.head.size
  def size = rowCount * colCount

  def *(other : SimpleMatrix) : Matrix = {
    val transposedRows =
      for (row <- this.rowVectors)
        yield for(col <- other.transpose.rowVectors)
          yield row zip col map (x => x._1 * x._2) reduceLeft (_+_)
    new SimpleMatrix(transposedRows)
  }

  def transpose: SimpleMatrix =
    new SimpleMatrix(rowVectors.transpose)

  def sum: Double =
    rowVectors map (x => x.sum) reduce (_+_)

  override def equals(that: Any): Boolean =
    that match {
      case that: SimpleMatrix => (that.isInstanceOf[SimpleMatrix]
                && !((that.rowVectors zip this.rowVectors) exists (x => x._1 != x._2))
                && this.hashCode == that.hashCode)
      case _ => false
    }

  override def hashCode: Int = {
    val prime = 31
    val result = 1
    prime * result + sum.toInt
  }

}
