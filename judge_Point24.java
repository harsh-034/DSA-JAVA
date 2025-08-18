
/*
You are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.

You are restricted with the following rules:

The division operator '/' represents real division, not integer division.
For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator.
For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
You cannot concatenate numbers together
For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.
Return true if you can get such expression that evaluates to 24, and false otherwise.


Example 1:

Input: cards = [4,1,8,7]
Output: true
Explanation: (8-4) * (7-1) = 24
Example 2:

Input: cards = [1,2,1,2]
Output: false


Topics: Array, Math, Backtracking
*/



class Solution {
    public boolean judgePoint24(int[] cards) {
       
        double[] nums = new double[4];// convert int[] to double
        for (int i = 0; i < 4; i++) {
            nums[i] = (double) cards[i];//convert all value in index number 
        }
        return backtrack(nums, 4);//this function are use for convert for use opretar
    }

    private boolean backtrack(double[] nums, int n) {
        // if only one number left 
        if (n == 1) {
            return Math.abs(nums[0] - 24) < 1e-6;// check if it is close to 24
        }

        // pick two numbers(j,j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                double a = nums[i], b = nums[j];
                double[] results = { //take all possible arthmatic operation 
                    a + b,
                    a - b,
                    b - a,
                    a * b,
                    (Math.abs(b) < 1e-6 ? Double.NaN : a / b),//ther are cheke not 0 in niche
                    (Math.abs(a) < 1e-6 ? Double.NaN : b / a)
                };

                // make a new array with remaining numbers
                double[] next = new double[n - 1]; 
                int k = 0;
                for (int m = 0; m < n; m++) {
                    if (m != i && m != j) {  //If index m is NOT i or j (the two chosen numbers), we copy it into next.
                        next[k++] = nums[m];
                    }
                }

                // try each possible result
                for (double val : results) {
                    if (Double.isNaN(val)) continue; // skip invalid division
                    next[k] = val; // put result at end
                    if (backtrack(next, n - 1)) return true;
                }
            }
        }
        return false;
    }
}

//out put 

/* 
Input:
cards = [4,1,8,7]
Output: true
Expected: true
*/



