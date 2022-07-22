// Using Recursion 

class Solution{

	public int minCoins(int coins[], int M, int V) 
    {
      
       if (V == 0) return 0;
        if (V < 0) return Integer.MAX_VALUE;
      
       
       int res = Integer.MAX_VALUE;
      
       for (int i=0; i<M; i++)
       {
         int ans = minCoins(coins, M, V-coins[i]);
                if (ans != Integer.MAX_VALUE )
                res = Math.min(res,ans + 1);
         
       }
       return res;
    }
}