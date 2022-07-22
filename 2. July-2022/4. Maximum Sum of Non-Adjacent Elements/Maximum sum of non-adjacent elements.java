// Recursion 


import java.util.*;
public class Solution {
public static int solve (ArrayList<Integer> nums , int n){
    if (n < 0) 
        return 0;
    if (n == 0) 
        return nums.get(n);
    
    int include = solve(nums,n-2)+nums.get(n);
    int exclude = solve(nums,n-1)+0;
    return Math.max(include , exclude);
    
    
}

	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();
        int ans = solve(nums,n-1);
        return ans;
	}
}

// Memorization 

import java.util.*;
public class Solution {
public static int solve (ArrayList<Integer> nums , int n ,int[] dp){
            if (n < 0)
              return 0;
           if (n==0)
           return nums.get(n);
          if (dp[n] != -1){
             return dp[n];}
        
            int include = solve(nums,n-2 , dp) + nums.get(n);
            int exclude = solve(nums,n-1 , dp)+0;
            
        
           return dp[n] = Math.max(include, exclude);
    
    
}

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums,n-1,dp);
    }
}





// Tabulation

import java.util.*;
public class Solution {
public static int solve (ArrayList<Integer> nums , int n ,int[] dp){
       if(n==1)return nums.get(0);
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(0), nums.get(1));
        for(int i=2;i<n;i++){
            int include = dp[i-2] + nums.get(i);
            int exclude = dp[i-1]+0;
            dp[i] = Math.max(include, exclude);
        }
    return dp[n-1];
    
    
}

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, -1);
        return solve(nums,n,dp);
    }
}

// same

import java.util.*;
public class Solution {
    public static int solve(ArrayList < Integer > nums) {
        int n = nums.size();
        int[] dp = new int[n];
        if (n == 1) return nums.get(0);
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < n; i++) {
            int include = dp[i - 2] + nums.get(i);
            int exclude = dp[i - 1] + 0;

            dp[i] = Math.max(include, exclude);
        }
        return dp[n - 1];
    }

    public static int maximumNonAdjacentSum(ArrayList < Integer > nums) {

        return solve(nums);
    }
}


Space Optimization - 

import java.util.*;
public class Solution {
    public static int solve(ArrayList < Integer > nums) {
        int n = nums.size();
        int prev2 = 0;
        int prev1 = nums.get(0);
       for (int i = 1; i < n; i++) {
            int include = prev2 + nums.get(i);
            int exclude = prev1 + 0;

            int ans = Math.max(include, exclude);
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }

    public static int maximumNonAdjacentSum(ArrayList < Integer > nums) {

        return solve(nums);
    }
}