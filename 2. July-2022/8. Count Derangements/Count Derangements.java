Recursion - 
T - O(2^n)
S - O(n)

public class Solution {
    static long MOD = 1000000007; //The answer could be very large, output answer %(10 ^ 9 + 7).
    public static long countDerangements(int n) {
        // Base conditions.
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        // Recurse for other subproblems.
        long ans = ((n - 1) % MOD * (countDerangements(n - 1) % MOD + countDerangements(n - 2) % MOD) % MOD) % MOD;
        return ans;
    }
}







Memoization 
T - O(n)
S - O(n)+O(n) 

import java.util.*;
public class Solution {
    static long MOD = 1000000007;
    public static long memoization (int n , long dp[] ) {
        // Base conditions.
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }
      if (dp[n]!=-1) return dp[n];

       
        return dp[n] = ((n - 1) % MOD * (memoization (n - 1 , dp) % MOD + memoization (n - 2,dp) % MOD) % MOD) % MOD;
        
    }
    
     public static long countDerangements(int n ) {
         long dp[] = new long[n+1];
         Arrays.fill(dp,-1);
         return memoization (n , dp);
 }
}






Tabulation - 
T - O(n)
S - O(n)

import java.util.*;
public class Solution {
    static long MOD = 1000000007;
    public static long tab (int n) {
        
         long dp[] = new long[n+1];
         Arrays.fill(dp,Integer.MIN_VALUE);
        
       
        dp[1] = 0;
        dp[2] = 1;

          for (int i= 3; i <= n ; i++){
              dp[i] = ((i-1)% MOD* (dp[i - 1]% MOD + dp[i - 2]% MOD))% MOD;
          }
        return dp[n];
}
    
     public static long countDerangements(int n ) {

         return tab (n );
     }
}





Space Optimization - 
Tabulation - 
T - O(n)
S - O(1)


import java.util.*;
public class Solution {
    static long MOD = 1000000007;
    public static long space (int n) {
        long prev1 = 0;
        long prev2 = 1;

          for (int i= 3; i <= n ; i++){
              long curr = ((i-1)% MOD* ( prev1 % MOD + prev2% MOD))% MOD;
              prev1=prev2;
              prev2=curr;
          }
        return prev2;
        
    }
    public static long countDerangements(int n ) {

         return space (n );
 }
}