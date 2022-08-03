Recursion - 
/*
    Time complexity: O(2^N)
    Space complexity: O(N)

    Where 'N' and 'K' are input integers.
*/

public class Solution {
     // Driver function to get the modular addition.
    public static int add(int a, int b) {
        int mod = (int)1e9 + 7;
        return (int)(((long)(a % mod) + (b % mod)) % mod);
    }

    // Driver function to get the modular multiplication.
    public static int mul(int a, int b) {
        int mod = (int)1e9 + 7;
        return (int)(((long)(a % mod) * (b % mod)) % mod);
    }

    // Function to get the number of ways to paint the fence with 'N' posts and 'K' colors.
    public static int solve(int n, int k) {
        // Checking for the base conditions.
        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return mul(k, k);
        }

         else {
            // Returning the answer according to the calculated formula.
            return add(mul(solve(n - 1, k), (k - 1)), mul(solve(n - 2, k), (k - 1)));
        }
    }
    
    public static int numberOfWays(int n, int k) {
        // Returning the 'solve(n, k)' result.
        return solve(n, k);
    }
}







Memo - T- O(n)  S - O(n)+O(n)

import java.util.*;
public class Solution {
     // Driver function to get the modular addition.
    public static int add(int a, int b) {
        int mod = (int)1e9 + 7;
        return (int)(((long)(a % mod) + (b % mod)) % mod);
    }

    // Driver function to get the modular multiplication.
    public static int mul(int a, int b) {
        int mod = (int)1e9 + 7;
        return (int)(((long)(a % mod) * (b % mod)) % mod);
    }

    // Function to get the number of ways to paint the fence with 'N' posts and 'K' colors.
    public static int solveMem(int n, int k , int[]dp) {
        // Checking for the base conditions.
        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return mul(k, k);
        }
         if (dp[n]!=-1) return dp[n];

         else {
            // Returning the answer according to the calculated formula.
            return dp[n] = add(mul(solveMem(n - 1, k , dp), (k - 1)), mul(solveMem(n - 2, k , dp), (k - 1) ));
        }
    }
    
    public static int numberOfWays(int n, int k) {
        // Returning the 'solve(n, k)' result.
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solveMem(n, k , dp);
    }
}







Tab T- O(n)  S - O(n)

import java.util.*;
public class Solution {
    
    
     // Driver function to get the modular addition.
    public static int add(int a, int b) {
        int mod = (int)1e9 + 7;
        return (int)(((long)(a % mod) + (b % mod)) % mod);
    }

    // Driver function to get the modular multiplication.
    public static int mul(int a, int b) {
        int mod = (int)1e9 + 7;
        return (int)(((long)(a % mod) * (b % mod)) % mod);
    }

    // Function to get the number of ways to paint the fence with 'N' posts and 'K' colors.
    public static int solveTab(int n, int k ) {
        
        
        int dp[] = new int[n+2];
        Arrays.fill(dp,-1);
        // Checking for the base conditions.
        dp[1] = k;

        dp[2] = mul(k,k);
           
   for(int i = 3;i <= n; i++){
    dp[i] = add(mul(dp[i-2],k-1),mul(dp[i-1],k-1));
       
   }
    return dp[n];
}
    
    public static int numberOfWays(int n, int k) {
        // Returning the 'solve(n, k)' result.
       return solveTab(n, k);
    }
}








Space T- O(n)  S - O(1)

import java.util.*;
public class Solution {
    
    
     // Driver function to get the modular addition.
    public static int add(int a, int b) {
        int mod = (int)1e9 + 7;
        return (int)(((long)(a % mod) + (b % mod)) % mod);
    }

    // Driver function to get the modular multiplication.
    public static int mul(int a, int b) {
        int mod = (int)1e9 + 7;
        return (int)(((long)(a % mod) * (b % mod)) % mod);
    }

    // Function to get the number of ways to paint the fence with 'N' posts and 'K' colors.
    public static int space(int n, int k ) {
        
        
        int dp[] = new int[n+2];
        Arrays.fill(dp,-1);
        // Checking for the base conditions.
        int prev1 = k;

        int prev2 = mul(k,k);
           
   for(int i = 3;i <= n; i++){
   int curr = add(mul(prev1,k-1),mul(prev2,k-1));
               prev1=prev2;
              prev2=curr;
          }
        return prev2;
 
}
    
    public static int numberOfWays(int n, int k) {
        // Returning the 'solve(n, k)' result.
       return space(n, k);
    }
}