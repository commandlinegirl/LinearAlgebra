# Linear algebra

A random collection of notes

## Cayley-Hamilton theorem 

Every matrix is a zero of it's characteristic polynomial.

## Determinants

A matrix and its transpose have the same determinant. So, a matrix and its transpose have the same characteristic polynomial 

<a href="https://www.codecogs.com/eqnedit.php?latex=|tI&space;-&space;A|&space;=&space;|tI&space;-&space;A^T|" target="_blank"><img src="https://latex.codecogs.com/gif.latex?|tI&space;-&space;A|&space;=&space;|tI&space;-&space;A^T|" title="|tI - A| = |tI - A^T|" /></a>

## Matrix similarity

A is similar to B (A ~ B) if A and B are nxn matrices and there exists a matrix P such that:

<a href="https://www.codecogs.com/eqnedit.php?latex=P^{-1}AP&space;=&space;B" target="_blank"><img src="https://latex.codecogs.com/gif.latex?P^{-1}AP&space;=&space;B" title="P^{-1}AP = B" /></a>

Similar matrices:
* represent the same linar operator under (potentially) different bases (_P_ is a _change of basis_ matrix) 
* have the same characteristic polynomial


## Characteristic polynomial of a matrix

Characteristic polynomial of A is a determinant of a **characteristic matrix** of A (t*In-A):

<a href="https://www.codecogs.com/eqnedit.php?latex=det(t*I_n&space;-&space;A)" target="_blank"><img src="https://latex.codecogs.com/gif.latex?det(t*I_n&space;-&space;A)" title="det(t*I_n - A)" /></a>

* Eigenvalues of A are roots of characteristic polynomial of A.
* Matrix A and its transpose have the same characteristic polynomial.


## Matrix diagonalization

A diagnolizable matrix is _similar_ to a diagonal matrix. 

Two problems might appear when we try to put a matrix into a diagonal form: i. the eigenvalues might not be within a field of interest, ii. the eigenvectors belonging to the eigenvalues might not form a basis (an nxn matrix has to have n linearly independent eigenvectors). In such cases we might want to put the matrix into **Jordan Canonical Form**.

A linear operator T:V->V has a diagonal matrix representation iff its minimal polynomial m(t) is a product of distinct linear polynomials.

## Linear functional

A linear functional on a vector space V is a linear mapping T from V into its field K of scalars (T:V->K). An example is a trace mapping T where T assigns a trace (sum of diagonal elements) to a n-square matrices in a space V.

## Homomorphism, first dual space, second dual space

Let V and U be vector spaces over a field K. Then the collection of all linear mappings from V into U with the linear operations (addition and scalar multiplication) form a vector space over K. The vector space is Hom(V, U).

Dual vector space V* is a collection of all linear functionals on V (together with addition and scalar multiplication). Dual space is also a vector space of K. The dimensions of V and V* are equal. V* itself has its own dual space, called _second dual space_ V**. 

## Bilinear form and quadratic form

Bilinear form on a finite-dimension vector space V over field K is a mapping f: V x V -> K, which is linear in each of the arguments separately. Example if a dot product function f on Rn.

## Rank, kernel and nullity

Let T be a linear transformation T:V->U. The image of T (ImF) is the set of image points in U:

<a href="https://www.codecogs.com/eqnedit.php?latex=ImT&space;=&space;{\{u:&space;T(v)&space;=&space;u\}}" target="_blank"><img src="https://latex.codecogs.com/gif.latex?ImT&space;=&space;{\{u:&space;T(v)&space;=&space;u\}}" title="ImT = {\{u: T(v) = u\}}" /></a>

The kernel of T (KerT, null space) is a set of elements in V which map into 0 in U:

<a href="https://www.codecogs.com/eqnedit.php?latex=KerT&space;=&space;{\{&space;v&space;:&space;T(v)&space;=&space;0&space;\}}" target="_blank"><img src="https://latex.codecogs.com/gif.latex?KerT&space;=&space;{\{&space;v&space;:&space;T(v)&space;=&space;0&space;\}}" title="KerT = {\{ v : T(v) = 0 \}}" /></a>

* Image is a subspace of U and kernel is a subspace of V.
* Nullity - dimKerT
* Rank - dimImT

