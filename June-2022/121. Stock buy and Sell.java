//1st solution(bruteforce)

/*Solution 1: Intuition: We can simply use 2 loops and track every transaction and maintain a variable maxPro to contain the max value among all transactions.

Approach: 

Use a for loop of ‘i’ from 0 to n.
Use another for loop from ‘i+1’ to n.
If prices[j] > prices[i] , take the difference and compare  and store it in the maxPro variable.
Return maxPro.

Time complexity: O(n^2)

Space Complexity: O(1)*/



import java.util.*;
public class Main {
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        int maxPro = maxProfit(prices);
        System.out.println("Max profit is: " + maxPro);
    }
    static int maxProfit(int[] prices) {
        int maxPro = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxPro = Math.max(prices[j] - prices[i], maxPro);
                }
            }
        }
        return maxPro;
    }
}

//___________________________________________________________________________________







/* Solution 2: Optimal solution 

Intuition: We will linearly travel the array. We can maintain a minimum from the starting of the array and compare it with every element of the array, if it is greater than the minimum then take the difference and maintain it in max, otherwise update the minimum.

Approach:

Create a variable maxPro and mark it as 0.
Create a variable minPrice and mark it as max_value.
Run a for loop from 0 to n.
Update the minPrice at if it greater than current element of the array
Take the difference of the minPrice with the current element of the array and compare and maintain it in maxPro.
Return the maxPro.*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    int prices[] = {7,1,5,3,6,4};

    int maxPro = maxProfit(prices);
    System.out.println("Max profit is: " + maxPro);

  }
  static int maxProfit(int[] prices) {
    int maxPro = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {
      minPrice = Math.min(minPrice, prices[i]);
      maxPro = Math.max(maxPro, prices[i] - minPrice);
    }
    return maxPro;
  }
}




//*************************************************************

//LEETCODE

//************************************************************



class Solution {
  public int maxProfit(int[] prices) {
    int maxPro = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {
      minPrice = Math.min(minPrice, prices[i]);
      maxPro = Math.max(maxPro, prices[i] - minPrice);
    }
    return maxPro;
  }
}



//************************************************************

// Coding ninja - https://www.codingninjas.com/codestudio/problems/893405?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=3

//************************************************************

 

// Explaination:-

// As we know when we buy at minimum price and sell at max then we get profit . Similary approach we can used ,we try to sell at each position (suppossing we buy at minimum value at left). 

 

// start traver from left.
// update currminimum  value .
// Calculate the profit we get if we sell it today .
// update maxProfit .
 

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        
        int maxProfit=0;
        int currmin=Integer.MAX_VALUE;
        for(int i=0;i<prices.size();i++){
            currmin=Math.min(currmin,prices.get(i));
            int profit=prices.get(i)-currmin;
            maxProfit=Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
