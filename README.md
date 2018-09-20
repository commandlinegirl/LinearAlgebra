# Linear Algebra

Implementation of some of the matrix operations in Scala plus a random collection of notes on linear algebra.

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


## Bilinear, quadratic, sesquilinear, hermitian form

### Bilinear form

Bilinear form on a finite-dimension vector space V over field K is a mapping f:VxV->K, which is linear in each of the arguments separately. Example is a dot product function on Rn. Matrix representation of _f_ relative to a basis {ei} [1]:

Let _f_ be a bilinear form on _V_, and let {e1, ..., en} be a basis of _V_. Suppose that _u_,_v_ belong to _V_ and suppose

<a href="https://www.codecogs.com/eqnedit.php?latex=u&space;=&space;a_1e_1&space;&plus;&space;...&space;&plus;&space;a_ne_n,&space;v&space;=&space;b_1e_1&space;&plus;&space;...&space;&plus;&space;b_ne_n" target="_blank"><img src="https://latex.codecogs.com/gif.latex?u&space;=&space;a_1e_1&space;&plus;&space;...&space;&plus;&space;a_ne_n,&space;v&space;=&space;b_1e_1&space;&plus;&space;...&space;&plus;&space;b_ne_n" title="u = a_1e_1 + ... + a_ne_n, v = b_1e_1 + ... + b_ne_n" /></a>

Then

<a href="https://www.codecogs.com/eqnedit.php?latex=f(u,&space;v)&space;=&space;f(a_1e_1&space;&plus;&space;...&space;&plus;&space;a_ne_n,&space;b_1e_1&space;&plus;&space;...&space;&plus;&space;b_ne_n)&space;=&space;a_1b_1f(e_1,&space;e_1)&space;&plus;&space;a_1b_2f(e_1,&space;e_2)&space;&plus;&space;...&space;&plus;&space;a_nb_nf(e_n,&space;e_n)&space;=&space;\sum&space;^n&space;_{i,j&space;=&space;1}&space;a_ib_if(e_i,e_j)" target="_blank"><img src="https://latex.codecogs.com/gif.latex?f(u,&space;v)&space;=&space;f(a_1e_1&space;&plus;&space;...&space;&plus;&space;a_ne_n,&space;b_1e_1&space;&plus;&space;...&space;&plus;&space;b_ne_n)&space;=&space;a_1b_1f(e_1,&space;e_1)&space;&plus;&space;a_1b_2f(e_1,&space;e_2)&space;&plus;&space;...&space;&plus;&space;a_nb_nf(e_n,&space;e_n)&space;=&space;\sum&space;^n&space;_{i,j&space;=&space;1}&space;a_ib_if(e_i,e_j)" title="f(u, v) = f(a_1e_1 + ... + a_ne_n, b_1e_1 + ... + b_ne_n) = a_1b_1f(e_1, e_1) + a_1b_2f(e_1, e_2) + ... + a_nb_nf(e_n, e_n) = \sum ^n _{i,j = 1} a_ib_if(e_i,e_j)" /></a>

Thus, _f_ is comletely determined by the n^2 values f(ei, ej).

The matrix A = (aij) where aij = f(ei, ej) is called the matrix representation of f relative to a basis {ei}. For all _u_,_v_ belonging to _V_:

<a href="https://www.codecogs.com/eqnedit.php?latex=f(u,&space;v)&space;=&space;\sum&space;^n&space;_{i,j&space;=&space;1}&space;a_ib_if(e_i,e_j)&space;=&space;(a_1,&space;...&space;a_n)&space;A&space;\begin{pmatrix}&space;\\&space;b_1&space;\\&space;b_2&space;\\&space;...&space;\\&space;b_n&space;\end{pmatrix}&space;=&space;\left&space;[&space;u&space;\right&space;]_e&space;^T&space;A&space;\left&space;[&space;v&space;\right&space;]&space;_e" target="_blank"><img src="https://latex.codecogs.com/gif.latex?f(u,&space;v)&space;=&space;\sum&space;^n&space;_{i,j&space;=&space;1}&space;a_ib_if(e_i,e_j)&space;=&space;(a_1,&space;...&space;a_n)&space;A&space;\begin{pmatrix}&space;\\&space;b_1&space;\\&space;b_2&space;\\&space;...&space;\\&space;b_n&space;\end{pmatrix}&space;=&space;\left&space;[&space;u&space;\right&space;]_e&space;^T&space;A&space;\left&space;[&space;v&space;\right&space;]&space;_e" title="f(u, v) = \sum ^n _{i,j = 1} a_ib_if(e_i,e_j) = (a_1, ... a_n) A \begin{pmatrix} \\ b_1 \\ b_2 \\ ... \\ b_n \end{pmatrix} = \left [ u \right ]_e ^T A \left [ v \right ] _e" /></a>

**Congruent matrices** represent the same bilinear form in different bases. A matrix B is congruent to matrix A if there exists an invertible matrix P such that

<a href="https://www.codecogs.com/eqnedit.php?latex=B&space;=&space;P^{T}AP" target="_blank"><img src="https://latex.codecogs.com/gif.latex?B&space;=&space;P^{T}AP" title="B = P^{T}AP" /></a>

### Quadraric form

Quadraric form is a function f:Rn->R of the form

<a href="https://www.codecogs.com/eqnedit.php?latex=f(x)&space;=&space;x^{T}Ax&space;=&space;\sum&space;_{i,j=1}^{n}A_{ij}x_ix_j" target="_blank"><img src="https://latex.codecogs.com/gif.latex?f(x)&space;=&space;x^{T}Ax&space;=&space;\sum&space;_{i,j=1}^{n}A_{ij}x_ix_j" title="f(x) = x^{T}Ax = \sum _{i,j=1}^{n}A_{ij}x_ix_j" /></a>

where A = A^T (A is symmetric).

A mapping q:v->K is a quadratic form if q(v) = f(v, v) for some symmetric bilinear form f on V.

### Sesquilinear form

Sesquilinear form is a generalization of a bilinear form. Bilinear form must be linear in both arguments while sesquilinear form allows one of the arguments to be "twisted" in a [semilinear](https://en.wikipedia.org/wiki/Semilinear_map) manner.

### Hermitian form

Also called a symmetric sesquilinear form, it is a sesquilinear form h:V×V->C such that

<a href="https://www.codecogs.com/eqnedit.php?latex=f(w,&space;z)&space;=&space;\overline{f(z,&space;w)}" target="_blank"><img src="https://latex.codecogs.com/gif.latex?f(w,&space;z)&space;=&space;\overline{f(z,&space;w)}" title="f(w, z) = \overline{f(z, w)}" /></a>

The function _f_ is linear in the first variable but conjugate linear in the second variable. The matrix representation of a complex Hermitian form is a Hermitian matrix, which is a matrix that is equal to its _conjugate transpose_. A real matrix is Hermitian iff it is symmetric.

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

[1] _Theory and Problems of Linear Algebra_, Lipschutz, 1968
