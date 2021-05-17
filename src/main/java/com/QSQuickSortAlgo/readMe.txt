Time complexity analysis:


1. Based on the worst case / best case; we will have different results for the time complexity analysis.

=> Best case : when the given array is equally divided into 2 sub arrays in the partition call.
	In such case, the recursive call can be written as:
	
	T(n) = 2 T(n/2) + 0(n); 	0(n) is computation time for partition function. 
	
	=> O(n * log n) time complexity

=> Worst case : when the given array is divided in such way that at either of the side, there will be only one element for partition
				and all remaining (n-1) elements will be at other side.
				
				This uneven distribution of elements will result in a recursive call as:
				
	T(n) = T(n-1) + 0(n); 		0(n) is computation time for partition function.
	
	=> 0(n^2) time complexity
	
=> Average case : O(n * log n) time complexity

##

In practical approach, in either of the partition approach, if a sorted array is provided; then the partition function will turn into
it's worst case; which will degrade performance even for sorted arrays.

In actual implementation, a random position is chosen within the range 0 -> n ('n' array length) [excluding those extremes].
And according to the partition function, either first OR last (Lomuto - last element) / (Hoare - first element) element is 
swapped with this random index number. And then the standard function is continued.

By doing this, the partition function will not result in it's worst case for any sorted input array.
 