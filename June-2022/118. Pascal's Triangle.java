//*************************************************************

//LEETCODE ( CodeXam )

//************************************************************


/*
Intuition: When you see the image above, you get a pretty good idea of what you are supposed to do here. Think about the image as a matrix now where each line is basically a row in the matrix. So, first things first, if you are at the edge of the matrix, the value is 1, that’s for sure. Now, what about the inner elements? Well, any inner element is obtained by doing the sum of the 2 values present in the row just above it, i.e., if the element is at index (i, j), then matrix[i][j] can be obtained by doing matrix[i – 1][j – 1] + matrix[i – 1][j].

Approach: To solve the problem, we need to first create an array of size N or numRows (input value). This array is used to store each of the rows expected in the output, so, for example, array[1] = [1,1]. In this array, the number of columns (say, numCols) is equal to the number of the i-th row + 1 (Since, 0-indexed), i.e., for 0-th row, numCols = 1. So, the number of columns is different for each row.

Next, we need to run a loop from i = 0 to numRows – 1 (inclusive) in order to store each row in our array. For each of iteration of this loop, we follow the below steps:

Create an array of size (i + 1) (For some languages such as C++, you need to create a 2D array at the start of the program and resize array[i] to (i + 1)).
Set the first and last value of array[i] to 1.
Run another loop from j = 1 to i – 1 (inclusive) and for each iteration put array[i][j] = array[i – 1][j – 1] + array[i – 1][j].
After iterating numRows times, you return the array.

Dry Run: Let’s do a dry run to understand it in a much better way.

Input: numRows = 5

Step – I: Initialized an array of size numRows, array = [[],[],[],[],[]]
Step – II: Run a loop from i = 0 to numRows – 1
At i = 0:
We resize the first row of the array to (i + 1) = (0 + 1) = 1, so array = [[0],[],[],[],[]].
Set the first and last value of array[i] = 1, so, array[0][0] = 1 and array[0][i] = 1. Therefore, array = [[1],[],[],[],[]]
Since, i = 0, the nested for loop does not satisfy the running criteria and hence does not get executed.
At i = 1:
We resize the second row of the array to (i + 1) = (1 + 1) = 2, so array = [[1],[0,0],[],[],[]].
Set the first and last value of array[i] = 1, so, array[1][0] = 1 and array[1][i] = 1. Therefore, array = [[1],[1,1],[],[],[]]
Since, i = 1, the nested for loop does not satisfy the running criteria and hence does not get executed.
At i = 2:
We resize the third row of the array to (i + 1) = (2 + 1) = 3, so array = [[1],[1,1],[0,0,0],[],[]].
Set the first and last value of array[i] = 1, so, array[2][0] = 1 and array[2][i] = 1. Therefore, array = [[1],[1,1],[1,0,1],[],[]]
Run a loop from j = 1 to i – 1:
At j = 1:
array[i][j] = array[i – 1][j – 1] + array[i – 1][j]
   = array[1][0] + array[1][1] = 1 + 1 = 2

So, array = [[1],[1,1],[1,2,1],[],[]]

At i = 3 and i = 4, we follow the same approach to fill the two rows of the array and get array = [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]].
Step – III: Return array.
*/







// My Code (video)


/* Time Complexity: We are creating a 2D array of size (numRows * numCols) (where 1 <= numCols <= numRows), and we are traversing through each of the cells to update it with its correct value, so Time Complexity = O(numRows2).

Space Complexity:  = O(1). */


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row , prev_row = null;
        
        for(int i = 0; i < numRows ; i++){
            row = new ArrayList<Integer>();
            for(int j = 0 ; j <= i ; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }
                else
                    row.add(prev_row.get(j - 1) + prev_row.get(j));
            }
                    prev_row = row;
                    res.add(row); 
        }
        return res;
    }
}









//Another approach 
class Solution {
   public List<List<Integer>> generate(int numRows) {
       /* 
       List(Index)    row
        0              1
        1              2
        2              3
        3              4
        4              5
        
        
       if we wanna make a row(n)=5 we have to set the list as (n-2) means (5-2)=3 
       so index 3 means row 5
       
       
       */
       
       
       
       
       
       if(numRows==0) return new ArrayList();
        List<List<Integer>> result = new ArrayList(); //array list result of result 
       
      
       //all rows 
       
       
       
        for(int i=1;i<=numRows; i++){//we need to feel out entire 5 rows assume that numrow = 5
             List<Integer> row = new ArrayList();//4th-for single row  
             for(int j=0;j<i;j++){//2nd we need to make 5 rows means less than 5 index
                 if(j==0 || j==i-1){//6th -first and last position always 1(base case)
                     row.add(1);//7th- simple add if index position is 0 nd i-1
                 }else{
                     
                     /*
                     lookat the image for last row 1 4 6 4 1 
                     //1 element  ----- previous rows' 0 + 1(index)
                     //2 element  ----- previous rows' 1 + 2(index)
                     //3 element  ----- previous rows' 2 + 3(index)
                     
                    ****we need 4th row for develop the 5th row so already i told you we need (n-2)=3 position for that 5th row
                     */
                     
                     //8th -  i-2 = for develop 5th row 
                     //if we want to build an eement (suppose 3 = 2+3),we need that element(j)with previous element(j-1)
                     
    row.add(result.get(i-2).get(j)+result.get(i-2).get(j-1));//main element(from previous row)+previous element(from previous row)
                 }
            }
             result.add(row); //1 2 3 4 5 //5th add this row for result 
        }
        return result; //3rd-return result 
    }
}












// Coding Ninja
// https://www.codingninjas.com/codestudio/problems/1089580?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=3

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> ans = new ArrayList<ArrayList<Long>>();
        ArrayList<Long> cur = null;
        ArrayList<Long> prev = null;
        for(int i=0;i<n;i++){
           cur = new ArrayList<Long>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    cur.add( (long) 1);
                else
                    cur.add(prev.get(j) + prev.get(j-1));
               
            }
            prev = cur;
            ans.add(cur);
        }
        return ans;
                 
    }
}