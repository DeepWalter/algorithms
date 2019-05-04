# Permutations

## Lexicographic Permutations

The lexicographic permutations of $\{1, 2, 2, 3\}$ are:

$$\{1, 2, 2, 3\}, \{1, 2, 3, 2\}, \{1, 3, 2, 2\}, \{2, 1, 2, 3\}, \{2, 1, 3, 2\}, \{2, 2, 1, 3\}, \{2, 2, 3, 1\},
\{2, 3, 1, 2\}, \{2, 3, 2, 1\}, \{3, 1, 2, 2\}, \{3, 2, 1, 2\}, \{3, 2, 2, 1\}$$

Notice that elements in the first permutation $\{1, 2, 2, 3\}$ are in increasing order, while elements in the last
permutation $\{3, 2, 2, 1\}$ are in decreasing order. This simple fact gives rise to the criterion that *a permutation
has a successor in lexicographic order iff its elements are not in decreasing order*.

Moreover, we can apply the above criterion to a part of the collection. Let's fix the first two elements, e.g
$\{1, 2\}$, and consider all permutations starting with $\{1, 2\}$. The above criterion implies that $\{1, 2, 2, 3\}$
has a successor since $\{2, 3\}$ is not in decreasing order. And this is the case since $\{1, 2, 3, 2\}$ is its
immediate successor. Similarly, $\{1, 2, 3, 2\}$ has no successor since $\{3, 2\}$ is in decreasing order. This
observation gives us the idea of how to find the next permutation in lexicographic order:

* find the first pair in increasing order from right to left;
* fix those element in the left side of the pair;
* then find the next permutation among the remaining elements that are not fixed.

Finding the next permutation among the remaining elements is easy. Assume the remaining elements of the current
permutation are $\{a_j, a_{j+1}, \cdots, a_n\}$. From the above assumption we have $a_j < a_{j+1} \ge \cdots \ge a_n$.
To find the next permutation, we need to replace $a_j$ with its successor. Assume $a_l$ is the successor, i.e. the
smallest element in $\{a_{j+1}, \cdots, a_n\}$ such that $a_l > a_j$. We swap $a_j$ with $a_l$ and then sort all
elements excluding $a_l$ (the first one) in increasing order. This gives us the next permutations of
$\{a_{j}, \cdots, a_n\}$. Notice that, after the swap, $\{a_{j+1}, \cdots, a_l, \cdots, a_n\}$ is in decreasing order,
hence we can just reverse them to sort them into increasing order.

### Algorithm for lexicographic permutation generation

Assume $a_1 \le a_2 \le \cdots \le a_n$. The following steps generates all permutations in lexicographic order:

1. Visit the permutation $\{a_1, \cdots, a_n\}$.
2. Set $j \longleftarrow n-1$. If $a_j \ge a_{j+1}$, decrease $j$ by $1$ repeatedly until $a_j < a_{j+1}$. Terminate if
  $j = 0$.
3. Set $l \longleftarrow n$. If $a_l \le a_j$, decrease $l$ by $1$ repeatedly until $a_j < a_l$. Then interchange
  $a_j \longleftrightarrow a_l$.
4. Set $k \longleftarrow j+1$ and $l \longleftarrow n$. Then, if $k < l$, interchange $a_k \longleftrightarrow a_l$,
  set $k \longleftarrow k+1$ and $l \longleftarrow l-1$, and repeat until $k \ge l$.
5. Return to step 1.

See [Permutations.java](./algorithms/src/main/java/algorithms/Permutations.java) for implementation of the above algorithm.