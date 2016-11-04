package com.commandlinegirl.linalg.datastructures

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
    rowVectors map (x => x.sum) reduce (_ + _)

  override def equals(that: Any): Boolean =
    that match {
      case that: SimpleMatrix => (that.isInstanceOf[SimpleMatrix]
        && that.rowVectors.deep == this.rowVectors.deep
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
