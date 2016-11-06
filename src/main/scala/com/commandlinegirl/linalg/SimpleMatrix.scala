package com.commandlinegirl.linalg

class SimpleMatrix(val rowVectors : Array[Array[Double]]) {

  def rowCount = rowVectors.length
  def colCount = rowVectors.head.length
  def size = rowCount * colCount
  def arrayData = rowVectors

  def *(other: SimpleMatrix): SimpleMatrix = {
    val transposedRows =
      for (row <- this.rowVectors)
        yield for (col <- other.transpose.rowVectors)
          yield row zip col map (x => x._1 * x._2) reduceLeft (_ + _)
    new SimpleMatrix(transposedRows)
  }

  def *(scalar: Double): SimpleMatrix = {
    val newRows =
      for (row <- this.rowVectors)
        yield row map (x => x * scalar)
    new SimpleMatrix(newRows)
  }

  def transpose: SimpleMatrix =
    new SimpleMatrix(rowVectors.transpose)

  def sum: Double =
    rowVectors map (x => x.sum) sum

  def nearEqualMatrix(that: SimpleMatrix): Boolean =
    rowCount == that.rowCount && (colCount == that.colCount) && (rowVectors.toList.flatten zip that.rowVectors.toList.flatten exists (x => nearEqualDouble(x._1, x._2)))

  def nearEqualDouble(a: Double, b: Double): Boolean =
    MathOp.~=(a, b, 0.000001)

  override def equals(that: Any): Boolean =
    that match {
      case that: SimpleMatrix => (that.isInstanceOf[SimpleMatrix]
        && nearEqualMatrix(that)
        && this.hashCode == that.hashCode)
      case _ => false
    }

  override def hashCode: Int = {
    val prime = 31
    val result = 1
    prime * result + sum.toInt
  }

  override def toString: String =
    rowVectors.deep.mkString(" ")

}
