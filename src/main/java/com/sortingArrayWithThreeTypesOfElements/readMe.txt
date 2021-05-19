There are different variations for this problem. All solutions are given.

1. Sort the given array of 0s, 1s, & 2s as such that 0s comes first, then 1s and then 2s. (Q1*.java)

	i/p: {0, 1, 0, 2, 1, 2} => o/p: {0, 0, 1, 1, 2, 2}
	
2. Partition the given element with given pivot point such that all smaller elements should be on left of the pivot and higher
	on right side of the pivot. If multiple occurrences are there for pivot, they all need to be consecutive. (Q2*.java)

	i/p: {2, 1, 2, 20, 10, 20, 1} & pivot = 2 => o/p: {1, 1, 2, 2, 20, 10, 20}
	
3. Partition the given array around a given range in such a way that all elements from given range's smallest element comes
	on left & other elements comes on right. Range has 2 point {a, b} where a <= b.  (Q3*.java)

	i/p: {10, 5, 6, 3, 20, 9, 40} & range = [5, 10]	=> o/p: {3, 5, 6, 9, 10, 20, 40} 