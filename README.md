# LinearAlgebra

### Gaussian elimination

Returns the the matrix in [row echelon form](https://en.wikipedia.org/wiki/Row_echelon_form). Partial pivoting is used
which makes the elimination stable in most cases. In partial pivoting the row with the largest value is interchanged with
rows holding smaller pivots before elimination is continues. It is generally sufficient to reduce a round-off error.
If a zero pivot is encountered a swap with a row that will provide a non-zero pivot is made.

### Gauss Jordan elimination

Returns the matrix in [reduced row echelon form](https://en.wikipedia.org/wiki/Row_echelon_form). The elimination starts
the same way as Gaussian elimination but after obtaining row echelon form the elimination is continued up in the
upper right part of the matrix.



