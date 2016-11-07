package com.commandlinegirl.linalg

import com.commandlinegirl.linalg.MathUtils._

object QR {

  /**
    * Returns a tuple of an orthogonal matrix and a triangular matrix.
    * @param a matrix A
    * @return (Q, R)
    */
  def gramSchmidtModified(a: SimpleMatrix): (SimpleMatrix, SimpleMatrix) = {
    val vectors = a.rowVectors.clone()
    for (i <- vectors.indices) {
      vectors(i) = vectors(i).normalize.get
      for (j <- i + 1 until vectors.length) {
        val rij = vectors(i) dot vectors(j)
        vectors(j) = vectors(j) - vectors(i) * rij
      }
    }
    val Q = new SimpleMatrix(vectors)
    val R = Q.transpose * a
    (Q, R)
  }

}
