
// Using Recursion 



public class Solution {
    
    
    static int solveRec(int[]num , int x){
        if (x==0)
            return 0;
        if (x<0)
            return Integer.MAX_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < num.length; i++){
            int ans = solveRec(num, x- num[i]);
            if (ans != Integer.MAX_VALUE)
                mini = Math.min(mini,1+ans);
        }
        return mini;
        
    }
    
    
    public static int minimumElements(int num[], int x) {
         int ans = solveRec(num,x);
//             if (ans == Integer.MAX_VALUE)
//             return -1;
//             else 
//             return ans;
         return ans == Integer.MAX_VALUE ?-1:ans;

    }
      
}




___________________________________________________________________

//Using Memorization / Top down



import java.util.*;
public class Solution {
    
    
    static int solveMem(int[]num , int x , int[]dp){
      
        if (x==0)
            return 0;
        if (x<0)
           return Integer.MAX_VALUE;
        
   
            if (dp[x] != -1)
          return dp[x];
       
        int mini = Integer.MAX_VALUE;;
        
        for(int i = 0; i < num.length; i++){
            int ans = solveMem(num, x- num[i], dp);
            if (ans != Integer.MAX_VALUE)
                mini = Math.min(mini,1+ans);
        }

    dp[x] = mini;
    
    return mini;
}
    
    
    public static int minimumElements(int num[], int x) {
         
         int dp [] = new int[x+1];
        Arrays.fill(dp, -1);
        
        int ans = solveMem(num , x , dp);
        // if (ans == Integer.MAX_VALUE)
        //     return -1;
        // else 
        //     return ans;
        return ans == Integer.MAX_VALUE ? -1:ans;//same as above 
     }
      
}


___________________________________________________________________

// Tabulation / Bottom -Up



import java.util.*;
public class Solution {
    
    
    static int solveTab(int[]num , int x ){
        int[] dp = new int[x + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
             for(int j = 0; j < num.length; ++j)//same as above
                  {if(i-num[j] >= 0 && dp[i - num[j]] != Integer.MAX_VALUE){
            dp[i] = Math.min(dp[i] , 1 + dp[i - num[j]]);
                      }
               }
           }
            
            if(dp[x] != Integer.MAX_VALUE) 
                return dp[x];
              else 
                return -1;
        
     }
         public static int minimumElements(int num[], int x) {
         return solveTab(num , x);
    }
}





//same modify simply 

import java.util.*;
public class Solution {
    public static int minimumElements(int num[], int x) {
        
    int[] dp = new int[x + 1];
        Arrays.fill(dp, x + 1);
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
            
            //  for(int j = 0; j < num.length; ++j)//same as above
            //       {if(i-num[j] >= 0 && dp[i - num[j]] != Integer.MAX_VALUE){
            // dp[i] = Math.min(dp[i] , 1 + dp[i - num[j]]);
            //           }
            //    }

            for (int j : num) {
                if ((i - j) >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[(i - j)]);
                }
            }
        }

        return dp[x] == x + 1 ? -1 : dp[x];
    }

}






