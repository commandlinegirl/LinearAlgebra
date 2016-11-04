package com.commandlinegirl.linalg

import com.commandlinegirl.linalg.datastructures.SimpleMatrix

object GaussianElimination {

  /**
    * Returns the matrix in upper row echelon form.
    */
  def gauss(a: SimpleMatrix): SimpleMatrix = {
    val rowVectors = a.arrayData
    for (i <- 0 until a.rowCount - 1) {
      val maxRow = (i+1 until a.rowCount).foldLeft(i)((max, r) =>
        if (rowVectors(r)(i).abs > rowVectors(max)(i).abs) r else max)
      swap(rowVectors, maxRow, i)
      val pivot = rowVectors(i)(i)
      for (j <- i + 1 until a.rowCount) {
        val eliminated = rowVectors(j)(i)
        val multiplier = eliminated / pivot
        rowVectors(j) = rowVectors(j) zip rowVectors(i) map (x => x._1 - multiplier * x._2)
        rowVectors(j)(i) = 0.0
      }
    }
    new SimpleMatrix((rowVectors map (_.toList)).toList)
  }

  def swap(a: Array[Array[Double]], i: Int, j: Int) = {
    val tmp = a(i)
    a(i) = a(j)
    a(j) = tmp
  }

}
