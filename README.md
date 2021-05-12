# Sort
Sort algo and other dependent algo

* -> Time complexity:	
* -> Space complexity:	
* -> Auxiliary space:

###
 
In Java for primitive values; Dual pivot quick sort algo is used. This algo does not guarantee stability. This is comparatively
faster compared to stability providing algos.

For wrapper classes; algo based on merge sort (derived from TimSort from python) is used which ensures stability. 

#Stability with an example

Ex: Consider data of branch of as student & it's roll number.
	
	[CS, 101], [ECE, 102], [CS, 104], [CS, 105], [ECE, 107] 

If above data is sorted by it's branch; the roll number should be in the same order as the data was fed.

	[CS, 101], [CS, 104], [CS, 105], [ECE, 102], [ECE, 107]
	
If we sort by branch, then roll number order is not changed; then it is called stability in sorting.	 

## Stable sort : Bubble sort, Insertion sort, Merge sort

## Unstable sort : Selection sort, Quick sort, Heap sort  

## In-place algo: 
An algo which does not need any additional data structure to store the elements. It will modify the existing structure only.

 
###

1. Java sorting and Arrays.sort() method

2. Collections.sort()

3. Stability in sorting algo

4. Bubble sort

5. Selection sort

6. Insertion sort

7. Merge sort / Merge function of Merge sort / Merge sort algo & analysis

8. Merge 2 sorted arrays

9. Intersection / Union of two sorted arrays

10. Count inversions in array

11. Naive / Lomuto / Hoare  partition

12. Quick sort / Quick sort using Lomuto & Hoare / Quick sort Algo analysis (space)   

### Java's primitive sorting : Dual Pivot Quick sort (learn how it works?)

13. Pivot selection in Quick sort & worst case analysis

14. Tail call elimination in Quick sort

15. Kth smallest element

16. Chocolate distribution problem

17. Sort an array with 2/3 types of elements

18. Minimum difference in an array

19. Merge overlapping elements

20. Meeting the maximum guest

21. Cycle sort

22. Heap sort

23. Counting sort

24. Radix sort

25. Bucket sort

26. Overview of sorting algo