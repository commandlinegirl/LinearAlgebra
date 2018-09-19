# Linear Algebra

A random collection of notes on linear algebra and implementations of some of the matrix operations.

## Matrix decompositions (implemented [here](https://github.com/commandlinegirl/LinearAlgebra/tree/commandlinegirl-patch-1/src/main/scala/com/commandlinegirl/linalg))

### QR decomposition (A = QR)

QR decomposition takes a matrix A of independent vectors and makes them orthonormal. Two vectors i and j are orthonormal if (a) they are unit vectors, (b) the dot product of i and j is 0 if i != j and 1 of i == j. The result is a matrix Q composed of the orthonormal vectors and R - an upper triangular matrix. This implementation uses modified Gram Schmidt algorithm which is more numerically stable than the classical variation. In the classical Gram Schmidt process at each step we subtract from every newly considered vector its projections that are parallel to directions set at previous steps. In the modified process as soon as the currently considered vector is made orthogonal and normalized it can be used to subtract it's parallel projection from all further vectors. In the Householder reflections method the loss of orthogonality of the Q factor is even smaller but it is not implemented here.

### LU decomposition (A = LU)

#### Gaussian elimination

Returns the the matrix in [row echelon form](https://en.wikipedia.org/wiki/Row_echelon_form). Partial pivoting is used which makes the elimination numerically stable in most cases. In partial pivoting the row with the largest absolute value is interchanged with rows holding smaller pivots before elimination continues. It is generally sufficient to reduce a round-off error.

#### Gauss Jordan elimination

Returns the matrix in [reduced row echelon form](https://en.wikipedia.org/wiki/Row_echelon_form). The elimination starts the same way as Gaussian elimination but after obtaining a row echelon form the elimination is continued up in the upper right part of the matrix.
<!-- ### Eigendecomposition (A = QDQ-1) -->


## Cayley-Hamilton theorem 

Every matrix is a zero of it's characteristic polynomial.


## Determinants

A matrix and its transpose have the same determinant. A matrix and its transpose have the same characteristic polynomial 

<a href="https://www.codecogs.com/eqnedit.php?latex=|tI&space;-&space;A|&space;=&space;|tI&space;-&space;A^T|" target="_blank"><img src="https://latex.codecogs.com/gif.latex?|tI&space;-&space;A|&space;=&space;|tI&space;-&space;A^T|" title="|tI - A| = |tI - A^T|" /></a>


## Matrix similarity

A is similar to B (A ~ B) if A and B are nxn matrices and there exists a (_change of basis_) matrix P such that:

<a href="https://www.codecogs.com/eqnedit.php?latex=P^{-1}AP&space;=&space;B" target="_blank"><img src="https://latex.codecogs.com/gif.latex?P^{-1}AP&space;=&space;B" title="P^{-1}AP = B" /></a>

Similar matrices:
* represent the same linar operator under (potentially) different bases  
* have the same characteristic polynomial
* have the same _trace_. Trace can be thought of as a property of a linear operator rather than a particular matrix.


## Characteristic polynomial of a matrix

Characteristic polynomial of A is a determinant of a **characteristic matrix** of A (t*In-A):

<a href="https://www.codecogs.com/eqnedit.php?latex=det(t*I_n&space;-&space;A)" target="_blank"><img src="https://latex.codecogs.com/gif.latex?det(t*I_n&space;-&space;A)" title="det(t*I_n - A)" /></a>

* Eigenvalues of A are roots of characteristic polynomial of A.
* Matrix A and its transpose have the same characteristic polynomial (a matrix is similar to its transpose).


## Matrix diagonalization

Two problems might appear when we try to put a matrix into a diagonal form: i. the eigenvalues might not be within a field of interest, ii. the eigenvectors belonging to the eigenvalues might not form a basis (an nxn matrix has to have n linearly independent eigenvectors). In such cases we might want to put the matrix into **Jordan Canonical Form**.

A linear operator T:V->V has a diagonal matrix representation iff its minimal polynomial m(t) is a product of distinct linear polynomials.


## Linear functional

A linear functional on a vector space V is a linear mapping T from V into its field K of scalars (T:V->K). An example is a trace mapping T where T assigns a trace (sum of diagonal elements) to a n-square matrices in a space V.


## Homomorphism, first dual space, second dual space

Let V and U be vector spaces over a field K. Then the collection of all linear mappings from V into U with the linear operations (addition and scalar multiplication) form a vector space over K. The vector space is Hom(V, U).

Dual vector space V* is a collection of all linear functionals on V (together with addition and scalar multiplication). Dual space is also a vector space of K. The dimensions of V and V* are equal. V* itself has its own dual space, called _second dual space_ V**. 


## Bilinear form and quadratic form

Bilinear form on a finite-dimension vector space V over field K is a mapping f: V x V -> K, which is linear in each of the arguments separately. Example if a dot product function f on Rn.

A matrix B is **congruent** to matrix A if there exists an invertible matrix P such that

<a href="https://www.codecogs.com/eqnedit.php?latex=B&space;=&space;P^{t}AP" target="_blank"><img src="https://latex.codecogs.com/gif.latex?B&space;=&space;P^{t}AP" title="B = P^{t}AP" /></a>

## Sylvester's law of intertia

Two symmetric square matrices of the same size have the same number of positive, negative and zero eigenvalues iff they are congruent.

## Rank, kernel and nullity

Let T be a linear transformation T:V->U. The image of T (ImF) is the set of image points in U:

<a href="https://www.codecogs.com/eqnedit.php?latex=ImT&space;=&space;{\{u:&space;T(v)&space;=&space;u\}}" target="_blank"><img src="https://latex.codecogs.com/gif.latex?ImT&space;=&space;{\{u:&space;T(v)&space;=&space;u\}}" title="ImT = {\{u: T(v) = u\}}" /></a>

The kernel of T (KerT, null space) is a set of elements in V which map into 0 in U:

<a href="https://www.codecogs.com/eqnedit.php?latex=KerT&space;=&space;{\{&space;v&space;:&space;T(v)&space;=&space;0&space;\}}" target="_blank"><img src="https://latex.codecogs.com/gif.latex?KerT&space;=&space;{\{&space;v&space;:&space;T(v)&space;=&space;0&space;\}}" title="KerT = {\{ v : T(v) = 0 \}}" /></a>

* Image is a subspace of U and kernel is a subspace of V.
* Nullity - dimKerT
* Rank - dimImT

