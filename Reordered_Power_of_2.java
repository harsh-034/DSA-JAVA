/* 
You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

*/


class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] targetCount = countDigits(n);

       
        for (int i = 1; i <= 1_000_000_000; i <<= 1) {

            
            int[] powerCount = countDigits(i);

            

            if (Arrays.equals(targetCount, powerCount)) {
                return true; 
            }
        }
        return false;
    }

    
    private int[] countDigits(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return count;
    }

    }

/* 
Out put :



targetCount = {0,0,0,0,0,0,1,0,1,0}  // digits 4 and 6 appear once

i = 1  -> count {1,0,0,0,0,0,0,0,0,0}  (not match)
i = 2  -> count {0,1,0,0,0,0,0,0,0,0}  (not match)
...
i = 64 -> count {0,0,0,0,0,0,1,0,1,0}  (MATCH!) 

*/



/*
Topic	Where it’s used in code
Hash Table	        countDigits() uses an int[10] array like a hash table to store digit frequency.
Math	                Powers of two are generated using i <<= 1 (2 × each time).
Sorting              	In sortDigits() method (alternative way to check).
Counting	              countDigits() counts how many times each digit appears.
Enumeration	            The for loop checks all powers of two in range.
Weekly Contest 93        	This exact problem came from LeetCode Weekly Contest 93.





Example 1:

Input: n = 1
Output: true
Example 2:

Input: n = 10
Output: false
 

Constraints:

1 <= n <= 109
*/
  




