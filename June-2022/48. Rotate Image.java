//1st solution(bruteforce)

/*Solution 1:Brute force

Approach: Take another dummy matrix of n*n, and then take the first row of the matrix and put it in the last column of the dummy matrix, take the second row of the matrix, and put it in the second last column of the matrix and so.
Time Complexity: O(N*N) to linearly iterate and put it into some other matrix.

Space Complexity: O(N*N) to copy it into some other matrix.*/



import java.util.*;
class main {
    static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int rotated[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotated[][] = rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }

    }
}

//___________________________________________________________________________________







/* Solution 2: Optimal solution 

Intuition: By observation, we see that the first column of the original matrix is the reverse of the first row of the rotated matrix, so that’s why we transpose the matrix and then reverse each row, and since we are making changes in the matrix itself space complexity gets reduced to O(1).

Approach:

Step1: Transpose of the matrix. (transposing means changing columns to rows and rows to columns)

Step2: Reverse each row of the matrix.

Time Complexity: O(N*N) + O(N*N).One O(N*N) for transposing the matrix and the other for reversing the matrix.

Space Complexity: O(1).*/

import java.util.*;
class main {
    static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}




//*************************************************************

//LEETCODE

//************************************************************



class Solution {
  
    static void rotate(int[][] matrix) {
      
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}


//************************************************************

// Coding ninja - https://www.codingninjas.com/codestudio/problems/981260?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

//************************************************************
/*

    Time Complexity: O(N * M)
    Space Complexity: O(max(N, M)), 

    Where N is the number of rows and M is the number of columns in the matrix.

*/

import java.util.ArrayList;

public class Solution {

    public static void rotateMatrixHelper(ArrayList<ArrayList<Integer>> mat, int rowStart, int colStart, int rowEnd,
            int colEnd) {
        // Base Condition
        if (rowStart >= rowEnd || colStart >= colEnd) {
            return;
        }

        if (rowStart >= rowEnd - 1 || colStart >= colEnd - 1) {
            return;
        }

        int previous = mat.get(rowStart + 1).get(colStart);
        int current;

        // Move elements of first row from the remaining rows
        for (int i = colStart; i < colEnd; i++) {
            current = mat.get(rowStart).get(i);
            mat.get(rowStart).set(i, previous);
            previous = current;
        }

        rowStart++;

        // Move elements of last column from the remaining columns
        for (int i = rowStart; i < rowEnd; i++) {
            current = mat.get(i).get(colEnd - 1);
            mat.get(i).set(colEnd - 1, previous);
            previous = current;
        }
        colEnd--;

        // Move elements of last row from the remaining rows
        if (rowStart < rowEnd) {
            for (int i = colEnd - 1; i >= colStart; i--) {
                current = mat.get(rowEnd - 1).get(i);
                mat.get(rowEnd - 1).set(i, previous);
                previous = current;
            }
        }
        rowEnd--;

        // Move elements of first column from the remaining rows
        if (colStart < colEnd) {
            for (int i = rowEnd - 1; i >= rowStart; i--) {
                current = mat.get(i).get(colStart);
                mat.get(i).set(colStart, previous);
                previous = current;
            }
        }
        colStart++;

        // Recursively rotate inner rings
        rotateMatrixHelper(mat, rowStart, colStart, rowEnd, colEnd);

    }

    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {

        rotateMatrixHelper(mat, 0, 0, n, m);

    }
}