# LinearAlgebra

### LU decomposition (A = LU)

#### Gaussian elimination

Returns the the matrix in [row echelon form](https://en.wikipedia.org/wiki/Row_echelon_form). Partial pivoting is used which makes the elimination numerically stable in most cases. In partial pivoting the row with the largest absolute value is interchanged with rows holding smaller pivots before elimination continues. It is generally sufficient to reduce a round-off error.

#### Gauss Jordan elimination

Returns the matrix in [reduced row echelon form](https://en.wikipedia.org/wiki/Row_echelon_form). The elimination starts the same way as Gaussian elimination but after obtaining a row echelon form the elimination is continued up in the upper right part of the matrix.

### QR decomposition (A = QR)

QR decomposition takes a matrix A of independent vectors and makes them orthonormal. Two vectors i and j are orthonormal if (a) they are unit vectors, (b) the dot product of i and j is 0 if i != j and 1 of i == j. The result is a matrix Q composed of the orthonormal vectors and R - an upper triangular matrix. This implementation uses modified Gram Schmidt algorithm which is more numerically stable than the classical variation. In the classical Gram Schmidt process at each step we subtract from every newly considered vector its projections that are parallel to directions set at previous steps. In the modified process as soon as the currently considered vector is made orthogonal and normalized it can be used to subtract it's parallel projection from all further vectors. In the Householder reflections method the loss of orthogonality of the Q factor is even smaller but it is not implemented here.

<!-- ### Eigendecomposition (A = QDQ-1) -->

