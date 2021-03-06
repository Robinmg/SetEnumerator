# SetEnumerator

A fun project I completed for a Combinatorics class.

The purpose of this project was to enumerate generalized
versions of counting problems. Specifically:
* Sets of SubSets
* Sets of SubSequences
* Sequences of SubSets
* Sequences of SubSequences

## Sets of SubSets

These problems take the form of "In how many ways may you place
k distinct objects into k identical buckets". In thise case each Set contains the "buckets"
and each SubSet contains the "objects".

## Sets of Subsequences 

These problems are similar to Sets of Subsets in that the "buckets" are identical, however
the objects placed in the buckets may have different orderings. For example (1, 2, 3) and
(2, 3, 1) would be considered different.  

## Sequences of Subsets 

Here the buckets themselves may have order, but the objects in the buckets do not. So
{1, 3, 5}, {2, 7, 8} and {1, 5, 3}, {8, 2, 7} would be considered identical.

## Sequences of Subsequences

Finally in these collections both the buckets and objects within have order.
So for example(1, 2, 3), (4, 6, 5) and (1, 2, 3), (4, 5, 6) would be considered different.

#Types

In general the program enumerates all possible collection types up to a given size, in order
to apply restrictions to the sizes of the "buckets" you must apply a type. Say you wanted to find 
how many ways you may place 5 distinct objects into 3 identical buckets where one bucket must contain 3 objects
and the other two may only contain 1. Then you would define the "type" of the collection to be {3, 1, 1}. 
