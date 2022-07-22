Recursion - TLE
Time Complexity:O(3 ^ N)
Space Complexity:O(1)


public class Solution {
    public static int solveRec (int n, int x, int y, int z ){
        if (n < 0) return Integer.MIN_VALUE;
        if (n == 0) return 0;
        int a = solveRec(n-x ,x, y ,z ) + 1;
        int b = solveRec(n-y , x, y ,z ) + 1;
        int c = solveRec(n-z ,x, y ,z ) + 1;
        
        int ans = Math.max(a,Math.max(b,c) );
        return ans;
    }
 public static int cutSegments(int n, int x, int y, int z) {
        int ans = solveRec(n,x,y,z);
        if (ans<0)
            return 0;
        else return ans;
    }
}



Memoization - 
Time Complexity:O(N)
Space Complexity:O(N)+O(N)

import java.util.*;
public class Solution {
   public static int solveMem(int n, int x, int y, int z,int dp[]){
        if (n < 0) return Integer.MIN_VALUE;
        if (n == 0) return 0;
       
       if(dp[n]!=-1)return dp[n];
       int a=1+solveMem(n-x,x,y,z,dp);
       int b=1+solveMem(n-y,x,y,z,dp);
       int c=1+solveMem(n-z,x,y,z,dp);
       
       return dp[n]= Math.max(a,Math.max(b,c));
   }
    
    
    public static int cutSegments(int n, int x, int y, int z) {
       int dp[]=new int[n+1];
       Arrays.fill(dp,-1);
       int ans= solveMem(n,x,y,z,dp);
       if(ans<0)return 0;
       else return ans;
   }
}





Tabulation 
Time Complexity:O(N)
Space Complexity:O(N)


Type 1 - Integer.MIN_VALUE

import java.util.*;
public class Solution {
   public static int solveTab(int n, int x, int y, int z){
       int dp[]=new int[n+1];
       Arrays.fill(dp,Integer.MIN_VALUE);
       dp[0] = 0;
       
       for (int i = 1; i<=n ; i++){
           if(i-x >= 0)
               dp[i] = Math.max(dp[i],dp[i-x]+1);
           
           if(i-y >= 0)
              dp[i] = Math.max(dp[i],dp[i-y]+1); 
           
           if(i-z >= 0)
              dp[i] = Math.max(dp[i],dp[i-z]+1); 
       }
       
       if(dp[n]<0)return 0;
       else 
           return dp[n];
   }
    
    
    public static int cutSegments(int n, int x, int y, int z) {
      
       return solveTab(n,x,y,z);
       
   }
}


Type 2 - -1

public class Solution {
   public static int solveTab(int n, int x, int y, int z){
       int dp[]=new int[n+1];
       Arrays.fill(dp,-1);
       
        
        dp[0] = 0;
       
       for (int i = 1; i<=n ; i++){
           if(i-x >= 0 && i-x !=-1)
               dp[i] = Math.max(dp[i],dp[i-x]+1);
           
           if(i-y >= 0 && i-y !=-1)
              dp[i] = Math.max(dp[i],dp[i-y]+1); 
           
           if(i-z >= 0 && i-z !=-1)
              dp[i] = Math.max(dp[i],dp[i-z]+1); 
       }
       
       if(dp[n]<0 )return 0;
       else 
           return dp[n];
   }
    
    
    
    public int maximizeCuts(int n, int x, int y, int z) {
             return solveTab(n,x,y,z);
   }
}