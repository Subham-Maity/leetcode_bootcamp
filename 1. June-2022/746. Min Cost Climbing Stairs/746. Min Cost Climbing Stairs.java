//Coding Ninja - try with Recursion  - https://www.codingninjas.com/codestudio/problems/count-ways-to-reach-nth-stairs_798650?leftPanelTab=1 
// but we get TLE Error
public class Solution {
    
    static int solve(long nStairs, int i){
        if (i == nStairs)
            return 1;
        if (i>nStairs)
            return 0;
        return (solve(nStairs,i+1)+solve(nStairs, i+2));
    }
    
    public static int countDistinctWayToClimbStair(long nStairs) {
        int ans = solve(nStairs,0);
        return ans;
    }
    
}



//LeetCode - https://leetcode.com/problems/min-cost-climbing-stairs/


//TLE Error - Try With Recursion First 

class Solution {
  static int solve(int[] cost, int n) {
    //BASE CASE
    if (n == 0)

      return cost[0];

    if (n == 1)

      return cost[1];

    int ans = cost[n] + Math.min(solve(cost, n - 1), solve(cost, n - 2));
    
    return ans;
  }
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int arr[] = new int[n];
    int ans = Math.min(solve(cost, n - 1), solve(cost, n - 2));
    return ans;
  }
}






//Memorization Top Down Approach (after modify the Recursion)

Time Complexity - O(n)
Space Complexity - O(n)+O(n)

class Solution {
  public int minCostClimbingStairs(int[] cost) {

    //Step 1
    int n = cost.length;

    int[] dp = new int[n];

    Arrays.fill(dp, -1);

    int ans = Math.min(solve(cost, n - 1, dp), solve(cost, n - 2, dp));
    return ans;
  }

  static int solve(int[] cost, int n, int[] dp) {
    //BASE CASE
    if (n == 0)

      return cost[0];

    if (n == 1)

      return cost[1];

    //step 3
    if (dp[n] != -1)
      return dp[n];
    //step 2
    dp[n] = cost[n] + Math.min(solve(cost, n - 1, dp), solve(cost, n - 2, dp));

    return dp[n];
  }
}



//Tabulation/ Bottom-Up Approach (after modify the Recursion)
Time Complexity - O(n)
Space Complexity - O(n)(better than top down)

class Solution {
  public int minCostClimbingStairs(int[] cost) {

    int n = cost.length;
    return solve(cost, n);
  }

  static int solve(int[] cost, int n) {
    //first step 
    int[] dp = new int[n];

    //Second step 
    dp[0] = cost[0];
    dp[1] = cost[1];

    //3rd step 
    for (int i = 2; i < n; i++) {
      dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);

    }

    return Math.min(dp[n - 1], dp[n - 2]);
  }
}



//Space optimization 
Time Complexity - O(n)
Space Complexity - O(1)(better than Bottom-Up)
class Solution {
  public int minCostClimbingStairs(int[] cost) {

    int n = cost.length;
    return solve(cost, n);
    
  }

  static int solve(int[] cost, int n) {
    //first step 
    int[] dp = new int[n];

    //Second step 
    int prev2 = cost[0];
    int prev1 = cost[1];
    int curr = 0;

    
    for (int i = 2; i < n; i++) {
      //3rd step 
      curr = Math.min(prev1, prev2)+cost[i];
      prev2 = prev1;
      prev1 = curr;
      

    }

    return Math.min(prev1, prev2);
  }
}