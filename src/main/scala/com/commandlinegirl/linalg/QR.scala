package com.commandlinegirl.linalg

import VectorOp._

object QR {

  /**
    * Returns a tuple of an orthogonal matrix and a triangular matrix.
    * @param a matrix A
    * @return (Q, R)
    */
  def gramSchmidtModified(a: SimpleMatrix): (SimpleMatrix, SimpleMatrix) = {
    val vectors = a.rowVectors.clone()
    for (i <- vectors.indices) {
      vectors(i) = normalize(vectors(i)).get
      for (j <- i + 1 until vectors.length) {
        val rij = dot(vectors(i), vectors(j))
        vectors(j) = subtract(vectors(j), multiply(rij, vectors(i)))
      }
    }
    val Q = new SimpleMatrix(vectors)
    val R = Q.transpose * a
    (Q, R)
  }

}
