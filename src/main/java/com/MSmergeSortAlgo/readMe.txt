Time & Space complexity analysis for Merge sort:

Time & Space complexity for an array of 'n' size needs to be calculated in 2 parts:

	1. to make recursive calls & stack required for such recursive calls.
	2. to merge 2 sorted sub arrays into single array.
	
	
#2. To merge 2 sorted sub arrays of 'a' & 'b' size; merge function will take 0(a+b) time. Approximately 0(n).

#1. At each stage of the recursive call, array gets divided & then merging of sub arrays happen. 
	Calculating number of recursive calls will result in 0(log n) and as #2, at each stage, 0(n) work happens to merge the sorted arrays.
	
	So total work done = 0(n) * 0(log n) = 0(n * log n)  