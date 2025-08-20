//Leetcode Question :   https://leetcode.com/problems/count-square-submatrices-with-all-ones/solutions/7104253/count-square-submatrices-with-all-ones-b-pgpk/

/*


Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of   squares = 6 + 1 = 7.

  */
class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] num = new int[row][col];
        int total = 0;

        for(int i=0; i <row; i++)
        {
            for(int j=0; j< col; j++)
            {
                if(matrix[i][j]==1)
                {
                    if(i==0 || j==0)
                    {
                        num[i][j] = 1;
                    }else{
                        num[i][j]=1+ Math.min(num[i-1][j],Math.min(num[i][j-1],num[i-1][j-1]));
                    }   
                    total += num[i][j];
                }
            }
        }
         return total;
    }
        
}



/* OUTPUT:
matrix = [[0,1,1,1],[1,1,1,1],[0,1,1,1]]
Output 15
Expected
15


*/
