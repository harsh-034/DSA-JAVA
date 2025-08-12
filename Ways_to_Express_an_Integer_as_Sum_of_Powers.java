//Ways to Express an Integer as Sum of Powers

/* 
Given two positive integers n and x.

Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.

Since the result can be very large, return it modulo 109 + 7.

For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.

 Example 1:

Input: n = 10, x = 2
Output: 1
Explanation: We can express n as the following: n = 32 + 12 = 10.
It can be shown that it is the only way to express 10 as the sum of the 2nd power of unique integers.
Example 2:

Input: n = 4, x = 1
Output: 2
Explanation: We can express n in the following ways:
- n = 41 = 4.
- n = 31 + 11 = 4.

*/


class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;

        
        java.util.List<Integer> powers = new java.util.ArrayList<>();
        int i = 1;
        while (true) {
            long val = (long) Math.pow(i, x); 
            if (val > n) break;
            powers.add((int) val);
            i++;
        }

        
        int[] dp = new int[n + 1];
        dp[0] = 1; 

        
        for (int p : powers) {
            for (int sum = n; sum >= p; sum--) {
                dp[sum] = (dp[sum] + dp[sum - p]) % MOD;
            }
        }

        return dp[n];
    }
}
// output 
/*  
r n = 10, x = 2:

powers = [1, 4, 9]

The only valid combination: 3² + 1² → output = 1

*/

